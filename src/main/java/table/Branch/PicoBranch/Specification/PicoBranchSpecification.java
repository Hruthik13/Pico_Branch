package table.Branch.PicoBranch.Specification;


import org.springframework.data.jpa.domain.Specification;
import table.Branch.PicoBranch.Model.PicoBranch;

public class PicoBranchSpecification {

    public static Specification<PicoBranch> textInAllColumns(String searchText){
        if(!searchText.contains("%")){
            searchText="%"+searchText+"%";

        }
        String finalText = "%" + searchText.toLowerCase() + "%";
        return(root,query,builder) -> builder.and (builder.or(builder.like(builder.lower(root.get("name")), finalText)
                ),
                builder.equal(root.get("isDeleted"),0));
    }
}

