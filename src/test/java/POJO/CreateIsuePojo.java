package POJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CreateIsuePojo {
    private final String summary;
    private final ProjectPojo project;
    private String description;
}
