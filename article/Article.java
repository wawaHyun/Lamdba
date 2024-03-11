<<<<<<< HEAD

package article;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Article {
    private Long id ;
    private String title ;
    private String content;
    private String writer;
    @Builder(builderClassName =  "builer")
    public Article(Long id, String title, String content, String writer){
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
=======

package article;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Article {
    private Long id ;
    private String title ;
    private String content;
    private String writer;
    @Builder(builderClassName =  "builer")
    public Article(Long id, String title, String content, String writer){
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
>>>>>>> 2196d46e6208c0beff581b79a883ffc4796605a9
}