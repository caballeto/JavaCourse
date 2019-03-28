package com.labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Worker {
    private static final String DATA_PATH = "/home/caballeto/IdeaProjects/java-labs/faculties.txt";

    private double averageMark(Faculty[] faculties, String name) {
        double mean = 0;

        for (Faculty faculty : faculties) {
            if (faculty.getName().equalsIgnoreCase(name)) {
                for (Student student : faculty.getStudents()) {
                    mean += faculty.getMap().get(student.id);
                }
                return mean / faculty.getStudents().length;
            }
        }
        return -1;
    }

    private static Faculty[] professorFaculties(Faculty[] faculties, String name) {
        ArrayList<Faculty> selected = new ArrayList<>();

        for (Faculty faculty : faculties) {
            if (faculty.getProfessor().equalsIgnoreCase(name)) {
                selected.add(faculty);
            }
        }

        return selected.toArray(new Faculty[0]);
    }

    private Faculty search(Faculty[] faculties, String name) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equalsIgnoreCase(name)) {
                return faculty;
            }
        }
        return null;
    }

    public void prompt(Faculty[] faculties) {
        String professorName, facultyName; double average; int query;
        Scanner scanner = new Scanner(System.in);

        loop:
        while (true) {
            System.out.print("Insert query type. [0 - get professor's faculties, " +
                    "1 - average mark of faculty, 2 - get students of faculty, 3 - exit] \n> ");
            String line = scanner.nextLine().trim().toLowerCase();

            try {
                query = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("No such option available. Please try again.");
                continue;
            }

            switch (query) {
                case 0:
                    System.out.print("Insert professor name. \n> ");
                    professorName = scanner.nextLine().trim();
                    Faculty[] selected = professorFaculties(faculties, professorName);

                    if (selected.length == 0) {
                        System.out.printf("Invalid professor name: %s. No faculties found. \n", professorName);
                    } else {
                        for (Faculty faculty : selected) {
                            System.out.println(faculty);
                        }
                    }

                    break;

                case 1:
                    System.out.print("Insert faculty name. \n> ");
                    facultyName = scanner.nextLine().trim();
                    average = averageMark(faculties, facultyName);

                    if (average == -1) {
                        System.out.printf("Invalid faculty name: %s. \n", facultyName);
                    } else {
                        System.out.println(average);
                    }

                    break;
                case 2:
                    System.out.print("Insert faculty name. \n> ");
                    facultyName = scanner.nextLine().trim();
                    Faculty f = search(faculties, facultyName);

                    if (f == null) {
                        System.out.printf("Invalid faculty name: %s. \n", facultyName);
                    } else {
                        f.printStudents();
                    }

                    break;
                case 3:
                    break loop;

                default:
                    System.out.println("No such option available. Please try again.");
            }
        }
    }

    public static Faculty[] load() {
        try (Scanner scanner = new Scanner(new File(DATA_PATH))) {
            String[] nums = scanner.nextLine().trim().split("\\s");

            int numStudents = Integer.parseInt(nums[0]);
            int numFaculties = Integer.parseInt(nums[1]);

            Student[] students = new Student[numStudents];
            Faculty[] faculties = new Faculty[numFaculties];

            for (int i = 0; i < numStudents; i++) {
                students[i] = new Student(i, scanner.nextLine());
            }

            for (int i = 0; i < numFaculties; i++) {
                String[] parts = scanner.nextLine().split(",");

                int[] ids = Arrays.stream(parts[2].split(":")).mapToInt(Integer::parseInt).toArray();
                Student[] enrolled = new Student[ids.length];

                for (int j = 0; j < ids.length; j++) {
                    enrolled[j] = students[ids[j]];
                }
                faculties[i] = new Faculty(parts[0], parts[1], enrolled);
            }

            return faculties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
