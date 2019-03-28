package com.labs;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Faculty[] faculties = Worker.load();

        System.out.println("Faculties.");
        for (Faculty faculty : faculties) {
            System.out.println(faculty);
        }

        worker.prompt(faculties);
    }
}
