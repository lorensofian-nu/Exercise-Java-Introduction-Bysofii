package com.edu.ahorcado;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String[] WORDS = {
        "JAVA", "PROGRAMACION", "VARIABLE", "COMPILADOR", "DESARROLLO", "ALGORITMO", "CLASE", "METODO"
    };
    
    private static final String[] HINTS = {
        "Lenguaje de programacion orientado a objetos de Oracle.",
        "Proceso creativo de desarrollar software funcional.",
        "Contenedor de datos que puede cambiar durante la ejecucion.",
        "Programa que convierte codigo fuente a lenguaje maquina.",
        "Proceso sistematico de diseno, implementacion y pruebas de software.",
        "Secuencia finita de pasos para resolver un problema.",
        "Plantilla para crear objetos con caracteres comunes.",
        "Bloque de codigo reutilizable dentro de una clase."
    };

    private static int gamesPlayed = 0;
    private static int gamesWon = 0;
    private static int gamesLost = 0;
    private static double highestScore = 0.0;
    private static String lastPlayer = "-";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        System.out.println("==================================================");
        System.out.println("            JUEGO DEL AHORCADO - JAVA EDITION          ");
        System.out.println("==================================================");

        do {
            displayMainMenu();
            choice = readMenuChoice(input, 1, 3);

            switch (choice) {
                case 1:
                    playGame(input);
                    break;
                case 2:
                    displayStats();
                    break;
                case 3:
                    System.out.println("\nSaliendo del juego. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo de nuevo.");
                    break;
            }
        } while (choice != 3);

        input.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n----------------- MENU PRINCIPAL -----------------");
        System.out.println("1. Jugar");
        System.out.println("2. Ver estadisticas");
        System.out.println("3. Salir");
        System.out.print("Elige una opcion (1-3): ");
    }

    private static int readMenuChoice(Scanner scanner, int min, int max) {
        int option = -1;
        boolean isValid = false;

        while (!isValid) {
            String inputStr = scanner.nextLine().trim();
            try {
                option = Integer.parseInt(inputStr);
                if (option >= min && option <= max) {
                    isValid = true;
                } else {
                    System.out.printf("Opcion fuera de rango (%d-%d). Prueba de nuevo: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.printf("Entrada no valida. Ingresa un numero entre %d y %d: ", min, max);
            }
        }
        return option;
    }

    private static void playGame(Scanner scanner) {
        System.out.println("\n========================================");
        System.out.println("          COMIENZA UNA NUEVA PARTIDA     ");
        System.out.println("========================================");

        String playerName = "";
        while (playerName.isEmpty()) {
            System.out.print("Introduce tu nombre: ");
            String rawInput = scanner.nextLine();
            playerName = rawInput.trim().toUpperCase();
            if (playerName.isEmpty()) {
                System.out.println("El nombre no puede estar vacio.");
            }
        }
        lastPlayer = playerName;

        Random random = new Random();
        int wordIndex = random.nextInt(WORDS.length);
        String secretWord = WORDS[wordIndex];
        String wordHint = HINTS[wordIndex];

        final int MAX_ATTEMPTS = secretWord.length() > 6 ? 8 : 7;
        int attemptsLeft = MAX_ATTEMPTS;
        double score = 100.0;
        boolean gameWon = false;
        char lastGuess = ' ';

        int correctGuesses = 0;
        int wrongGuesses = 0;
        boolean hintUsed = false;

        StringBuilder wordMask = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            wordMask.append("_ ");
        }

        StringBuilder guessHistory = new StringBuilder();

        System.out.println("\nBienvenido, " + playerName + "!");
        System.out.printf("Palabra: %d letras. Intentos: %d\n", secretWord.length(), MAX_ATTEMPTS);

        while (attemptsLeft > 0 && !gameWon) {
            System.out.println("\n----------------------------------------");
            System.out.println("Palabra: " + wordMask.toString().trim());
            System.out.println("Letras intentadas: [" + (guessHistory.length() > 0 ? guessHistory.toString() : "Ninguna") + "]");
            System.out.printf("Intentos restantes: %d/%d\n", attemptsLeft, MAX_ATTEMPTS);

            if (attemptsLeft == 1 && !hintUsed) {
                System.out.println("\n[PISTA]: " + wordHint);
                for (int i = 0; i < secretWord.length(); i++) {
                    if (wordMask.charAt(i * 2) == '_') {
                        String hintLetter = secretWord.substring(i, i + 1);
                        System.out.println("[AYUDA]: La palabra contiene la letra '" + hintLetter + "'.");
                        break;
                    }
                }
                hintUsed = true;
            }

            System.out.print("Adivina una letra: ");
            String guessInput = scanner.nextLine().trim();

            if (guessInput.isEmpty()) {
                System.out.println("Debes introducir una letra.");
                continue;
            }

            lastGuess = guessInput.toUpperCase().charAt(0);

            if (!Character.isLetter(lastGuess)) {
                System.out.println("Solo se permiten letras (A-Z).");
                continue;
            }

            String guessStr = String.valueOf(lastGuess);

            if (guessHistory.indexOf(guessStr) != -1) {
                System.out.printf("Ya has intentado la letra '%c'. No pierdes un intento.\n", lastGuess);
                continue;
            }

            if (guessHistory.length() > 0) {
                guessHistory.append(", ");
            }
            guessHistory.append(lastGuess);

            boolean isCorrect = false;
            for (int i = 0; i < secretWord.length(); i++) {
                String wordChar = String.valueOf(secretWord.charAt(i));
                if (wordChar.equalsIgnoreCase(guessStr)) {
                    wordMask.setCharAt(i * 2, secretWord.charAt(i));
                    isCorrect = true;
                }
            }

            String feedback = isCorrect
                    ? String.format("Correcto! La letra '%c' esta en la palabra.", lastGuess)
                    : String.format("Incorrecto. La letra '%c' no esta en la palabra.", lastGuess);
            System.out.println(feedback);

            if (isCorrect) {
                correctGuesses++;
            } else {
                wrongGuesses++;
                attemptsLeft--;
            }

            if (wordMask.indexOf("_") == -1) {
                gameWon = true;
            }
        }

        int totalAttempts = correctGuesses + wrongGuesses;
        double accuracyPercentage = totalAttempts > 0
                ? ((double) correctGuesses / totalAttempts) * 100.0
                : 0.0;

        if (gameWon) {
            score = 100.0 + (attemptsLeft * 15.0) + (accuracyPercentage * 0.75);
        } else {
            score = Math.max(0.0, (correctGuesses * 10.0) - (wrongGuesses * 6.0));
        }

        gamesPlayed++;
        if (gameWon) {
            gamesWon++;
        } else {
            gamesLost++;
        }
        if (score > highestScore) {
            highestScore = score;
        }

        String gameResult = gameWon ? "VICTORIA" : "DERROTA";
        showGameSummary(playerName, gameResult, secretWord, attemptsLeft, MAX_ATTEMPTS, accuracyPercentage, score);
    }

    private static void showGameSummary(
            String playerName,
            String result,
            String secretWord,
            int remainingAttempts,
            int maxAttempts,
            double accuracy,
            double finalScore) {

        System.out.println("\n========================================");
        System.out.println("          RESUMEN DE LA PARTIDA         ");
        System.out.println("========================================");
        System.out.printf(Locale.US, "%-20s %s\n", "Jugador:", playerName);
        System.out.printf(Locale.US, "%-20s %s\n", "Resultado:", result);
        System.out.printf(Locale.US, "%-20s %s\n", "Palabra:", secretWord);
        System.out.printf(Locale.US, "%-20s %d/%d\n", "Intentos restantes:", remainingAttempts, maxAttempts);
        System.out.printf(Locale.US, "%-20s %.2f%%\n", "Precision:", accuracy);
        System.out.printf(Locale.US, "%-20s %.2f pts\n", "Puntuacion:", finalScore);
        System.out.println("========================================");
    }

    private static void displayStats() {
        System.out.println("\n========================================");
        System.out.println("           ESTADISTICAS DEL JUEGO        ");
        System.out.println("========================================");
        System.out.printf("%-22s %d\n", "Partidas jugadas:", gamesPlayed);
        System.out.printf("%-22s %d\n", "Partidas ganadas:", gamesWon);
        System.out.printf("%-22s %d\n", "Partidas perdidas:", gamesLost);
        System.out.printf(Locale.US, "%-22s %.2f pts\n", "Mejor puntuacion:", highestScore);
        System.out.printf("%-22s %s\n", "Ultimo jugador:", lastPlayer);
        System.out.println("========================================");
    }
}
