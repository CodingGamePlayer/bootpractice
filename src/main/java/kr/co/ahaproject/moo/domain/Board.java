package kr.co.ahaproject.moo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int id;
    private String title;
    private String body;
    private LocalDate regdate;

    private LocalDate moddate;

    private String userid;
}
