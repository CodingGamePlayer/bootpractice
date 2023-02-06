package kr.co.ahaproject.moo.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class file {
    private long id;

    private String origFilename;

    private String filename;

    private String filePath;

}
