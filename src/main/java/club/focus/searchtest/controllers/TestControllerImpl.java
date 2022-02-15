package club.focus.searchtest.controllers;

import club.focus.searchtest.db.TaskActionRepository;
import club.focus.searchtest.db.entity.TaskAction;
import club.focus.searchtest.db.specification.TaskActionSpecification;
import club.focus.searchtest.dto.PaginatedResultDto;
import club.focus.searchtest.dto.TaskActionDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;

@Service
public class TestControllerImpl implements TestController {
    @Inject
    TaskActionRepository taskActionRepository;

    @Override
    public PaginatedResultDto testSearch(int page, int size, String searchText) {

        var taskActions = new ArrayList<TaskActionDto>();

        var items = taskActionRepository.findAll(TaskActionSpecification.searchNameAndType(searchText),
                PageRequest.of(page, size, Sort.by("task.name").descending().and(Sort.by("actionType").ascending()))
        );

        var results = new PaginatedResultDto();
        results.setTotalSize(items.getTotalElements());
        results.setTotalPages(items.getTotalPages());
        results.setCurrentPage(items.getPageable().getPageNumber());
        results.setCurrentSize(items.getPageable().getPageSize());
        results.setSort(items.getPageable().getSort().toString());

        for (TaskAction i: items) {
            taskActions.add(new TaskActionDto(i.getId(),i.getStart(),i.getEnd(),i.getActionType(), i.getTask().getName()));
        }

        results.setResults(taskActions);


        return results;
    }
}
