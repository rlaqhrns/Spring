package com.green.jpademo.dto;


import com.green.jpademo.domain.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto { //Data Transfer Object(Value Object)
    private Long id;
    private String author;
    private String title;
    private  String  content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    //Service에서 호출될 메서드
    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id,String author, String title, String content,
                    LocalDateTime createdDate , LocalDateTime modifiedDate){
        this.id=id;
        this.author=author;
        this.title =title;
        this.content =content;
        this.createdDate =createdDate;
        this.modifiedDate=modifiedDate;
    }

}
