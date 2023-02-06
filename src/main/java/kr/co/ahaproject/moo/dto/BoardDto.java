package kr.co.ahaproject.moo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    private int id;
    private String title;

    private String body;
    private LocalDate regdate;
    private  LocalDate modddate;

    private String userid;

}
