package com.priyank.springapplication.courseapidata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(String courseId) {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findByCourseId(courseId)
                .forEach(lessons::add);
        return lessons;
    }

    public Lesson getLesson(String id) {
        return lessonRepository.findById(id).orElse(null);
    }

    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void updateLesson(String id, Lesson lesson) {
        Lesson existingLesson = lessonRepository.findById(id).orElse(null);

        existingLesson.setName(lesson.getName());
        existingLesson.setDescription(lesson.getDescription());

        lessonRepository.save(existingLesson);
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
