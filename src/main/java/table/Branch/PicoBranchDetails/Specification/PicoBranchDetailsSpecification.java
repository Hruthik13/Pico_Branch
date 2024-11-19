package table.Branch.PicoBranchDetails.Specification;


import org.springframework.data.jpa.domain.Specification;
import table.Branch.PicoBranchDetails.Model.PicoBranchDetails;

public class PicoBranchDetailsSpecification {

    public static Specification<PicoBranchDetails> textInAllColumns(String searchText){
        if(!searchText.contains("%")){
            searchText= "%"+searchText+"%";

        }
        String finalText = "%" + searchText.toLowerCase() + "%";

        return(root,query,builder) -> builder.and (builder.or(builder.like(builder.lower(root.get("branchId")), finalText),
                builder.and (builder.or(builder.like(builder.lower(root.get("clientId")), finalText)))
                ),
                builder.equal(root.get("isDeleted"),0));
    }

}