package com.example.interviewmanagementsystem.repository.interview.impl;

import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.interview.Interview;
import com.example.interviewmanagementsystem.entity.interview.Interviewer;
import com.example.interviewmanagementsystem.entity.jobs.Jobs;
import com.example.interviewmanagementsystem.enums.interview.InterviewResult;
import com.example.interviewmanagementsystem.enums.interview.ScheduleStatus;
import com.example.interviewmanagementsystem.repository.interview.InterviewRepositoryCustom;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewCandidateDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewJobDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewListDTO;
import com.example.interviewmanagementsystem.util.dto.interview.InterviewerListDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.util.StringUtils;

import java.util.List;

public class InterviewRepositoryCustomImpl implements InterviewRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void updateStatus(Integer id) {

        entityManager.createQuery("update Interview i set i.status = :status where i.id = :id")
                .setParameter("status", ScheduleStatus.Cancelled)
                .setParameter("id", id);
    }

    @Override
    public Candidates getCandidateByInterviewId(Integer id) {
        return (Candidates) entityManager.createQuery("select c from Interview i join i.candidates c where i.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Interview> getInterviewsPass() {
        return entityManager.createQuery("select i from Interview i join i.candidates c where i.result = :result and c.deleted = false ")
                .setParameter("result", InterviewResult.Passed)
                .getResultList();
    }

    @Override
    public List<InterviewListDTO> getAllInterview(String search, String interviewer, String status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<InterviewListDTO> query = criteriaBuilder.createQuery(InterviewListDTO.class);
        Root<Interview> root = query.from(Interview.class);
        Join<Interview, Interviewer> interviewInterviewerJoin = root.join("interviewers", JoinType.LEFT);
        Join<Interview, Candidates> interviewCandidatesJoin = root.join("candidates", JoinType.LEFT);
        Join<Interview, Jobs> interviewJobsJoin = root.join("jobs", JoinType.LEFT);

        Predicate searchPre = null;
        Predicate interviewerPre = null;
        Predicate statusPre = null;

        if (StringUtils.hasLength(search)) {
            Predicate scheduleTitle = criteriaBuilder.like(root.get("scheduleTitle"), "%" + search + "%");
            Predicate candidateName = criteriaBuilder.like(interviewCandidatesJoin.get("fullName"), "%" + search + "%");
            Predicate result = criteriaBuilder.equal(root.get("result"), search );
            Predicate job = criteriaBuilder.like(interviewJobsJoin.get("title"), "%" + search + "%");

            searchPre = criteriaBuilder.or(scheduleTitle, candidateName, result, job);

            query.where(searchPre);
        }

        if (StringUtils.hasLength(interviewer)) {
            interviewerPre =  criteriaBuilder.equal(interviewInterviewerJoin.get("interviewerName"),  interviewer );

            query.where(interviewerPre);
        }

        if (StringUtils.hasLength(status)) {
            statusPre =  criteriaBuilder.equal(root.get("status"), status );

            query.where(statusPre);
        }

        if (StringUtils.hasLength(search) && StringUtils.hasLength(interviewer)) {
            query.where(searchPre, interviewerPre);
        }

        if (StringUtils.hasLength(search) && StringUtils.hasLength(status)) {
            query.where(searchPre, statusPre);
        }

        if (StringUtils.hasLength(interviewer) && StringUtils.hasLength(status)) {
            query.where(interviewerPre, statusPre);
        }

        if (StringUtils.hasLength(search) && StringUtils.hasLength(interviewer) && StringUtils.hasLength(status)) {
            query.where(searchPre, interviewerPre, statusPre);
        }

        Selection<InterviewListDTO> selection = criteriaBuilder.construct(InterviewListDTO.class,
                root.get("id"),
                root.get("scheduleTitle"),
                root.get("interviewDate"),
                root.get("startTime"),
                root.get("endTime"),
                root.get("result"),
                root.get("status")
        );
        query.select(selection).distinct(true);

        Order orderByScheduleDate = criteriaBuilder.asc(root.get("interviewDate"));
        Order orderByStatus = criteriaBuilder.asc(criteriaBuilder.selectCase()
                .when(root.get("status").in("New"), 1)
                .when(root.get("status").in("Invited"), 2)
                .when(root.get("status").in("Interviewed"), 3)
                .when(root.get("status").in("Cancelled"), 4)
                .otherwise(5));

        query.orderBy(orderByStatus, orderByScheduleDate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<InterviewListDTO> getInterviewPaging(Integer pageIndex, Integer pageSize, String search, String interviewer, String status) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<InterviewListDTO> query = criteriaBuilder.createQuery(InterviewListDTO.class);
        Root<Interview> root = query.from(Interview.class);
        Join<Interview, Interviewer> interviewInterviewerJoin = root.join("interviewers", JoinType.LEFT);
        Join<Interview, Candidates> interviewCandidatesJoin = root.join("candidates", JoinType.LEFT);
        Join<Interview, Jobs> interviewJobsJoin = root.join("jobs", JoinType.LEFT);
        Predicate searchPre = null;
        Predicate interviewerPre = null;
        Predicate statusPre = null;

        if (StringUtils.hasLength(search)) {
            Predicate scheduleTitle = criteriaBuilder.like(root.get("scheduleTitle"), "%" + search + "%");
            Predicate candidateName = criteriaBuilder.like(interviewCandidatesJoin.get("fullName"), "%" + search + "%");
            Predicate result = criteriaBuilder.equal(root.get("result"), search );
            Predicate job = criteriaBuilder.like(interviewJobsJoin.get("title"), "%" + search + "%");

            searchPre = criteriaBuilder.or(scheduleTitle, candidateName, result, job);

            query.where(searchPre);
        }

        if (StringUtils.hasLength(interviewer)) {
            interviewerPre =  criteriaBuilder.like(interviewInterviewerJoin.get("interviewerName"), interviewer);

            query.where(interviewerPre);
        }

        if (StringUtils.hasLength(status)) {
            statusPre =  criteriaBuilder.equal(root.get("status"), status );

            query.where(statusPre);
        }

        if (StringUtils.hasLength(search) && StringUtils.hasLength(interviewer)) {
            query.where(searchPre, interviewerPre);
        }

        if (StringUtils.hasLength(interviewer) && StringUtils.hasLength(status)) {
            query.where(interviewerPre, statusPre);
        }

        if (StringUtils.hasLength(search) && StringUtils.hasLength(interviewer) && StringUtils.hasLength(status)) {
            query.where(searchPre, interviewerPre, statusPre);
        }


        Selection<InterviewListDTO> selection = criteriaBuilder.construct(InterviewListDTO.class,
                root.get("id"),
                root.get("scheduleTitle"),
                root.get("interviewDate"),
                root.get("startTime"),
                root.get("endTime"),
                root.get("result"),
                root.get("status")
        );
        query.select(selection).distinct(true);

        Order orderByScheduleDate = criteriaBuilder.asc(root.get("interviewDate"));
        Order orderByStatus = criteriaBuilder.asc(criteriaBuilder.selectCase()
                .when(root.get("status").in("New"), 1)
                .when(root.get("status").in("Invited"), 2)
                .when(root.get("status").in("Interviewed"), 3)
                .when(root.get("status").in("Cancelled"), 4)
                .otherwise(5));

        query.orderBy(orderByStatus, orderByScheduleDate);

        return entityManager.createQuery(query)
                .setFirstResult((pageIndex - 1) * pageSize)
                .setMaxResults(pageSize).getResultList();
    }

    @Override
    public List<InterviewerListDTO> getInterviewerById(Integer id) {
        return entityManager.createQuery("select new com.example.interviewmanagementsystem.util.dto.interview.InterviewerListDTO(iw.interviewerName) from Interview i join i.interviewers iw where i.id = :id", InterviewerListDTO.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public InterviewCandidateDTO getCandidateById(Integer id) {
        return entityManager.createQuery("select new com.example.interviewmanagementsystem.util.dto.interview.InterviewCandidateDTO(c.fullName) from Interview i join i.candidates c where i.id = :id", InterviewCandidateDTO.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public InterviewJobDTO getJobById(Integer id) {
        return entityManager.createQuery("select new com.example.interviewmanagementsystem.util.dto.interview.InterviewJobDTO(j.title) from Interview i join i.jobs j where i.id = :id", InterviewJobDTO.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Interview> getListInterviewByCandidateId(Integer id) {
        return entityManager.createQuery("select i from Interview i join i.candidates c where c.id = :id")
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Interviewer> findListInterviewerByInterviewId(Integer id) {
        return entityManager.createQuery("select it from Interview i join i.interviewers it where i.id = :id")
                .setParameter("id", id)
                .getResultList();
    }
}
