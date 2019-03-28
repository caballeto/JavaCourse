package com.labs;

import java.util.HashMap;
import java.util.Map;

public class Faculty {
    private static final int MAXIMUM_MARK = 5;

    private final String name;
    private final String professor;
    private String startTime;
    private String endTime;
    private Student[] students;
    private Map<Integer, Integer> map;

    public Faculty(String name, String professor, Student[] students) {
        this.name = name;
        this.professor = professor;
        this.students = students;
        this.map = new HashMap<>();

        for (Student student : students)
            map.put(student.id, (int) (Math.random() * MAXIMUM_MARK) );
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Faculty name : ");
        builder.append(name);
        builder.append(". Professor : ");
        builder.append(professor);
        builder.append(".");

        return builder.toString();
    }

    public String stringStudents() {
        StringBuilder builder = new StringBuilder();

        for (Student student : students) {
            builder.append(student.name);
            builder.append(" ");
            builder.append(map.get(student.id));
            builder.append("\n");
        }
        return builder.toString();
    }

    public void printStudents() {
        System.out.println(this.toString());
        System.out.println(this.stringStudents());
    }

    public Map<Integer, Integer> getMap() {
        return map;
    }

    public Student[] getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public String getProfessor() {
        return professor;
    }
}
