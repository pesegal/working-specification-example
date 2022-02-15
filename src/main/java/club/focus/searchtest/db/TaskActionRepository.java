package club.focus.searchtest.db;

import club.focus.searchtest.db.entity.TaskAction;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskActionRepository
        extends PagingAndSortingRepository<TaskAction, UUID>, JpaSpecificationExecutor<TaskAction> {

}
