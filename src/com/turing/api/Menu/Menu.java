package com.turing.api.Menu;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Menu {
    private Long id;
    private String category; //package
    private String menuItem; //소비자가 보는 메뉴 '1-회원가입)
    @Builder(builderClassName = "builder")
    public Menu(Long id, String category, String menuItem){
        this.id = id;
        this.category = category;
        this.menuItem = menuItem;
    }

}
