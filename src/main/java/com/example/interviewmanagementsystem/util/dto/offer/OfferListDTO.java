package com.example.interviewmanagementsystem.util.dto.offer;

import com.example.interviewmanagementsystem.enums.offer.OfferStatus;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferListDTO {
    private Integer id;

    private String note;

    private OfferStatus offerStatus;


}
