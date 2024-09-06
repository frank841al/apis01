package mi_gestion_tareas_api.servicio;

import mi_gestion_tareas_api.model.Task;
import mi_gestion_tareas_api.repositorio.RepositorioTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {

    @Autowired
    private RepositorioTask repoTask;

    public List<Task> getAllTasks() {
        return repoTask.findAll();
    }

    public Task saveTask(Task task) {
        return repoTask.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = repoTask.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        return repoTask.save(existingTask);
    }

    public void deleteTask(Long id) {
        repoTask.deleteById(id);
    }
}
