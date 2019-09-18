import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class DayService {
    @Autowired
    DayJpaRepository repository;

    public void add(Day day) {
        repository.save(toEntity(day));
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<Day> getDogs() {
        return (List<Day>) repository.findAll();
    }

    public Day getDayByNum(int num, String month) {
        Optional<Day> optionalDay = repository.findDay(num, month);
        return optionalDay.orElseThrow(() -> new DayNotFoundException("Couldn't find a Day with id: " + id));
    }

    private Day toEntity(Day day) {
        Day entity = day;
        entity.setDayNumber(day.getDayNumber());
        entity.setDayName(day.getDayName());
        entity.setDayMonth(day.getDayMonth());
        return entity;
    }

}