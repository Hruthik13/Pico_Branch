package table.Branch.PicoBranchDetails.Repository;

import table.Branch.PicoBranchDetails.DTO.PicoBranchDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import table.Branch.PicoBranchDetails.Model.PicoBranchDetails;


import java.util.List;
import java.util.Optional;

@Repository
public interface PicoBranchDetailsRepository extends JpaRepository<PicoBranchDetails,String> {
    List<PicoBranchDetails> findAllByIsDeletedAndBranchId(int i, String branchId);

    List<PicoBranchDetails> findAllByIsDeletedAndBranchIdAndIdIsNot(int i, String branchId, String id);


    List<PicoBranchDetails> findAllByIsDeleted(int i, Sort sort);

    List<PicoBranchDetails> findAllByIsDeleted(int isDeleted);

    Page<PicoBranchDetails> findAllByIsDeleted(int isDeleted, Pageable page);

    Page<PicoBranchDetails> findAll(Specification<PicoBranchDetails> textInAllColumns, Pageable pageable);

    @Query(
            "SELECT new table.Branch.PicoBranchDetails.DTO.PicoBranchDetailsDTO(" +
                    "picoBranchDetails.id, " +
                    "picoBranchDetails.clientId, " +
                    "picoBranchDetails.orgId, " +
                    "picoBranchDetails.branchId, " +
                    "picoBranchDetails.branchHeadId, " +
                    "picoBranchDetails.branchAdminId, " +
                    "picoBranchDetails.createdBy, " +
                    "picoBranchDetails.creationTime, " +
                    "picoBranchDetails.modifiedBy, " +
                    "picoBranchDetails.modificationTime, " +
                    "picoBranchDetails.isDeleted, " +
                    "picoBranchDetails.deletedBy, " +
                    "picoBranchDetails.deletionTime, " +
                    "picoBranch.name, " +
                    "picoBranch.description " +
                    " )" +
                    " FROM PicoBranchDetails as picoBranchDetails" +
                    " LEFT JOIN PicoBranch picoBranch on picoBranchDetails.branchId=picoBranch.id" +
                    " WHERE LOWER(picoBranch.name) like LOWER(:searchText) AND picoBranchDetails.isDeleted=0 OR LOWER(picoBranch.description) like LOWER(:searchText) "
    )
    Page<PicoBranchDetailsDTO> searchPaginated(@Param("searchText") String searchText, Pageable pageable);
}
