package com.example.Task_Management.repositories;

import com.example.Task_Management.dto.CountType;
import com.example.Task_Management.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>
{
    @Query(value = "select * from task order by due_date desc ", nativeQuery = true)
    public List<Task> getAllTaskByDueDate();

    @Query(value = "select new com.example.Task_Management.dto.CountType(COUNT(*)/(Select COUNT(*) from Task) *100, type ) from Task GROUP BY type")
    public List<CountType> getPercentageGroupByType();
}
