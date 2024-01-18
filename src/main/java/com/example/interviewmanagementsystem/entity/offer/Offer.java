package com.example.interviewmanagementsystem.entity.offer;

import com.example.interviewmanagementsystem.entity.BaseEntity;
import com.example.interviewmanagementsystem.entity.candidates.Candidates;
import com.example.interviewmanagementsystem.entity.candidates.Positions;
import com.example.interviewmanagementsystem.entity.candidates.Recruiters;
import com.example.interviewmanagementsystem.entity.interview.Interview;
import com.example.interviewmanagementsystem.entity.jobs.Levels;
import com.example.interviewmanagementsystem.entity.user.Department;
import com.example.interviewmanagementsystem.entity.user.User;
import com.example.interviewmanagementsystem.enums.offer.ContractType;
import com.example.interviewmanagementsystem.enums.offer.OfferStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Where(clause = "deleted=False")
public class Offer extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    @NotNull(message = "{ME002}")
    @JsonIgnore
    private Candidates candidate;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    @NotNull(message = "{ME002}")
    @JsonIgnore
    private Positions position;

    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = false)
    @NotNull(message = "{ME002}")
    @JsonIgnore
    private User approvedBy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "interview_id")
    @JsonIgnore
    private Interview interviewInfo;

    @Column(name = "contract_period_from")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractPeriodFrom;

    @Column(name = "contract_period_to")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contractPeriodTo;

    @Column(name = "interview_notes")
    private String interviewNotes;

    private boolean deleted=false;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "contract_type")
    @NotNull(message = "{ME002}")
    private ContractType contractType;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    @NotNull(message = "{ME002}")
    @JsonIgnore
    private Levels level;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "offer_status")
    @NotNull(message = "{ME002}")
    private OfferStatus offerStatus;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @NotNull(message = "{ME002}")
    @JsonIgnore
    private Department department;

    @ManyToOne
    @JoinColumn(name = "recruiter_owner_id")
    @JsonIgnore
    private Recruiters recruiterOwner;

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;


    @Column(name = "basic_salary")
    @NotNull(message = "{ME002}")
    private BigDecimal basicSalary;

    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "offer_token")
    private String offerToken;

}
