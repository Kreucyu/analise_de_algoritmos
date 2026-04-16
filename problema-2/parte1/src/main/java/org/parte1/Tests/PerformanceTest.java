package org.parte1.Tests;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PerformanceTest {
    public static void main(String[] args) {
        questaoUmTesteUm();
        questaoUmTesteDois();
        questaoDoisTesteUm();
        questaoTresTesteUm();
        questaoTresTesteDois();
        questaoQuatroTesteUm();
        questaoCincoTesteUm();
        //inserir aqui o teste 6
    }

    private static void questaoUmTesteUm() {
        System.out.println("\nQuestão 1-1:\n");
        int elementos = 100_000;
        int execucoes = 20;
        double[] valoresExecucoes = new double[execucoes];
        long start = 0;
        long end = 0;
        double total = 0;
        double somaValoresExecucoes = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            ArrayList<Integer> listaNormal = new ArrayList<>();
            start = System.nanoTime();
            for (int j = 0; j < elementos; j++) {
                listaNormal.add(j);
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucoes[i] = total;
        }

        for(int i = 0; i < execucoes; i++) {
            somaValoresExecucoes += valoresExecucoes[i];
        }
        double mediaValoresExecucoesNormal = somaValoresExecucoes / execucoes;
        System.out.println("1.1 Média Lista Normal para ser preenchida em Milissegundos: " + String.format("%.3f", mediaValoresExecucoesNormal) + " ms");

        somaValoresExecucoes = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            LinkedList<Integer> listaEncadeada = new LinkedList<>();
            start = System.nanoTime();
            for (int j = 0; j < elementos; j++) {
                listaEncadeada.add(j);
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucoes[i] = total;
        }

        for(int i = 0; i < execucoes; i++) {
            somaValoresExecucoes += valoresExecucoes[i];
        }
        double mediaValoresExecucoesEncadeada = somaValoresExecucoes / execucoes;
        System.out.println("1.1 Média Lista Encadeada para ser preenchida em Milissegundos: " + String.format("%.3f", mediaValoresExecucoesEncadeada) + " ms");

        double normal =  mediaValoresExecucoesNormal;
        double encadeada = mediaValoresExecucoesEncadeada;

        String sistemaMaisRapido = encadeada > normal ? "\nLista Normal" : "\nLista Encadeada";
        double vezesMaisRapida = encadeada > normal ? encadeada/normal : normal / encadeada;
        double porcentagemDeMelhora = (vezesMaisRapida - 1) * 100;

        System.out.println(sistemaMaisRapido + " é mais rápida e é " + String.format("%.2f", vezesMaisRapida) + " vezes mais rápida ou " + String.format("%.2f", porcentagemDeMelhora) + "%");
    }

    private static void questaoUmTesteDois() {
        System.out.println("\nQuestão 1-2:\n");
        int elementos = 100_000;
        int execuoes = 10;
        double[] valoresExecucao = new double[10];
        long start = 0;
        long end = 0;
        double total = 0;
        double somaValoresExecucoes = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < execuoes; i++) {
            ArrayList<Integer> lista = new ArrayList<>(10);
            start = System.nanoTime();
            for (int j = 0; j < elementos; j++) {
                lista.add(j);
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucao[i] = total;
        }

        for(int i = 0; i < execuoes; i++) {
            somaValoresExecucoes += valoresExecucao[i];
        }

        double mediaValoresDEZ = somaValoresExecucoes / execuoes;

        System.out.println("1.2 Total lista capacidade = 10: " +  String.format("%.3f", mediaValoresDEZ) + " ms");

        somaValoresExecucoes = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < execuoes; i++) {
            ArrayList<Integer> lista = new ArrayList<>(1000);
            start = System.nanoTime();
            for (int j = 0; j < elementos; j++) {
                lista.add(j);
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucao[i] = total;
        }

        for(int i = 0; i < execuoes; i++) {
            somaValoresExecucoes += valoresExecucao[i];
        }

        double mediaValoresMIL = somaValoresExecucoes / execuoes;

        System.out.println("1.2 Total lista capacidade = 1000: " +  String.format("%.3f", mediaValoresMIL) + " ms");

        somaValoresExecucoes = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < execuoes; i++) {
            ArrayList<Integer> lista = new ArrayList<>(100000);
            start = System.nanoTime();
            for (int j = 0; j < elementos; j++) {
                lista.add(j);
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucao[i] = total;
        }

        for(int i = 0; i < execuoes; i++) {
            somaValoresExecucoes += valoresExecucao[i];
        }

        double mediaValoresCEMMIL = somaValoresExecucoes / execuoes;

        System.out.println("1.2 Total lista capacidade = 100000: " +  String.format("%.3f", mediaValoresCEMMIL) + " ms");

        System.out.println("\nA configuração mais rápida é a de tamanho = 100.000");
        System.out.println("\nIsso acontece por que a de tamanho = 100.000 não precisa redimensionar seu tamanho como as outras precisam.");
    }

    private static void questaoDoisTesteUm() {
        System.out.println("\nQuestão 2:\n");

        int elementos = 100_000;
        int execucoes = 20;
        double[] valoresExecucoes = new double[execucoes];
        long start, end;
        double soma = 0;

        Random random = new Random();

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            ArrayList<Integer> lista = new ArrayList<>();

            start = System.nanoTime();
            for (int j = 0; j < elementos; j++) {
                int pos = lista.size() == 0 ? 0 : random.nextInt(lista.size());
                lista.add(pos, j);
            }
            end = System.nanoTime();

            valoresExecucoes[i] = (end - start) / 1_000_000.0;
        }

        for (double v : valoresExecucoes) soma += v;
        double mediaArray = soma / execucoes;

        System.out.println("ArrayList: " + String.format("%.3f", mediaArray) + " ms");

        soma = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            LinkedList<Integer> lista = new LinkedList<>();

            start = System.nanoTime();
            for (int j = 0; j < elementos; j++) {
                int pos = lista.size() == 0 ? 0 : random.nextInt(lista.size());
                lista.add(pos, j);
            }
            end = System.nanoTime();

            valoresExecucoes[i] = (end - start) / 1_000_000.0;
        }

        for (double v : valoresExecucoes) soma += v;
        double mediaLinked = soma / execucoes;

        System.out.println("LinkedList: " + String.format("%.3f", mediaLinked) + " ms");

        String maisRapida = mediaLinked > mediaArray ? "ArrayList" : "LinkedList";
        double vezes = mediaLinked > mediaArray ? mediaLinked / mediaArray : mediaArray / mediaLinked;

        System.out.println("\n" + maisRapida + " é mais rápida (" + String.format("%.2f", vezes) + "x)");
    }

    private static void questaoTresTesteUm() {
        System.out.println("\nQuestão 3-1:\n");
        int elementos = 100_000;
        int execucoes = 20;
        double[] valoresExecucoes = new double[execucoes];
        long start = 0;
        long end = 0;
        double total = 0;
        double somaValoresExecucoes = 0;



        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            ArrayList<Integer> listaNormal = new ArrayList<>();

            for(int j = 0; j < elementos; j++) {
                listaNormal.add(j);
            }

            start = System.nanoTime();
            while(!listaNormal.isEmpty()) {
                listaNormal.removeFirst();
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucoes[i] = total;
        }

        for(int i = 0; i < execucoes; i++) {
            somaValoresExecucoes += valoresExecucoes[i];
        }
        double mediaValoresExecucoesNormal = somaValoresExecucoes / execucoes;
        System.out.println("3.1 Média Lista Normal para ser esvaziada (primeiro elemento) em Milissegundos: " + String.format("%.3f", mediaValoresExecucoesNormal) + " ms");

        somaValoresExecucoes = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            LinkedList<Integer> listaEncadeada = new LinkedList<>();
            for(int j = 0; j < elementos; j++) {
                listaEncadeada.add(j);
            }

            start = System.nanoTime();
            while(!listaEncadeada.isEmpty()) {
                listaEncadeada.removeFirst();
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucoes[i] = total;
        }

        for(int i = 0; i < execucoes; i++) {
            somaValoresExecucoes += valoresExecucoes[i];
        }
        double mediaValoresExecucoesEncadeada = somaValoresExecucoes / execucoes;
        System.out.println("3.1 Média Lista Encadeada para ser esvaziada (primeiro elemento) em Milissegundos: " + String.format("%.3f", mediaValoresExecucoesEncadeada) + " ms");

        double normal =  mediaValoresExecucoesNormal;
        double encadeada = mediaValoresExecucoesEncadeada;

        String sistemaMaisRapido = encadeada > normal ? "\nLista Normal" : "\nLista Encadeada";
        double vezesMaisRapida = encadeada > normal ? encadeada/normal : normal / encadeada;
        double porcentagemDeMelhora = (vezesMaisRapida - 1) * 100;

        System.out.println(sistemaMaisRapido + " é mais rápida e é " + String.format("%.2f", vezesMaisRapida) + " vezes mais rápida ou " + String.format("%.2f", porcentagemDeMelhora) + "%");
    }

    private static void questaoTresTesteDois() {
        System.out.println("\nQuestão 3-2:\n");
        int elementos = 100_000;
        int execucoes = 20;
        double[] valoresExecucoes = new double[execucoes];
        long start = 0;
        long end = 0;
        double total = 0;
        double somaValoresExecucoes = 0;


        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            ArrayList<Integer> listaNormal = new ArrayList<>();

            for(int j = 0; j < elementos; j++) {
                listaNormal.add(j);
            }

            start = System.nanoTime();
            while(!listaNormal.isEmpty()) {
                listaNormal.removeLast();
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucoes[i] = total;
        }

        for(int i = 0; i < execucoes; i++) {
            somaValoresExecucoes += valoresExecucoes[i];
        }
        double mediaValoresExecucoesNormal = somaValoresExecucoes / execucoes;
        System.out.println("3.1 Média Lista Normal para ser esvaziada (último elemento) em Milissegundos: " + String.format("%.3f", mediaValoresExecucoesNormal) + " ms");

        somaValoresExecucoes = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            LinkedList<Integer> listaEncadeada = new LinkedList<>();
            for(int j = 0; j < elementos; j++) {
                listaEncadeada.add(j);
            }
            start = System.nanoTime();
            while(!listaEncadeada.isEmpty()) {
                listaEncadeada.removeLast();
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucoes[i] = total;
        }

        for(int i = 0; i < execucoes; i++) {
            somaValoresExecucoes += valoresExecucoes[i];
        }
        double mediaValoresExecucoesEncadeada = somaValoresExecucoes / execucoes;
        System.out.println("3.1 Média Lista Encadeada para ser esvaziada (último elemento) em Milissegundos: " + String.format("%.3f", mediaValoresExecucoesEncadeada) + " ms");

        double normal =  mediaValoresExecucoesNormal;
        double encadeada = mediaValoresExecucoesEncadeada;

        String sistemaMaisRapido = encadeada > normal ? "\nLista Normal" : "\nLista Encadeada";
        double vezesMaisRapida = encadeada > normal ? encadeada/normal : normal / encadeada;
        double porcentagemDeMelhora = (vezesMaisRapida - 1) * 100;

        System.out.println(sistemaMaisRapido + " é mais rápida e é " + String.format("%.2f", vezesMaisRapida) + " vezes mais rápida ou " + String.format("%.2f", porcentagemDeMelhora) + "%");
    }

    private static void questaoQuatroTesteUm() {
        System.out.println("\nQuestão 4:\n");

        int elementos = 100_000;
        int execucoes = 20;
        double[] valoresExecucoes = new double[execucoes];
        long start, end;
        double soma = 0;

        Random random = new Random();

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            ArrayList<Integer> lista = new ArrayList<>();

            for (int j = 0; j < elementos; j++) lista.add(j);

            start = System.nanoTime();
            while (!lista.isEmpty()) {
                int pos = random.nextInt(lista.size());
                lista.remove(pos);
            }
            end = System.nanoTime();

            valoresExecucoes[i] = (end - start) / 1_000_000.0;
        }

        for (double v : valoresExecucoes) soma += v;
        double mediaArray = soma / execucoes;

        System.out.println("ArrayList: " + String.format("%.3f", mediaArray) + " ms");

        soma = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            LinkedList<Integer> lista = new LinkedList<>();

            for (int j = 0; j < elementos; j++) lista.add(j);

            start = System.nanoTime();
            while (!lista.isEmpty()) {
                int pos = random.nextInt(lista.size());
                lista.remove(pos);
            }
            end = System.nanoTime();

            valoresExecucoes[i] = (end - start) / 1_000_000.0;
        }

        for (double v : valoresExecucoes) soma += v;
        double mediaLinked = soma / execucoes;

        System.out.println("LinkedList: " + String.format("%.3f", mediaLinked) + " ms");

        String maisRapida = mediaLinked > mediaArray ? "ArrayList" : "LinkedList";
        double vezes = mediaLinked > mediaArray ? mediaLinked / mediaArray : mediaArray / mediaLinked;

        System.out.println("\n" + maisRapida + " é mais rápida (" + String.format("%.2f", vezes) + "x)");
    }

    private static void questaoCincoTesteUm() {
        System.out.println("\nQuestão 5-1:\n");
        int elementos = 100_000;
        int execucoes = 20;
        int consultas = 10_000;
        double[] valoresExecucoes = new double[execucoes];
        long start = 0;
        long end = 0;
        double total = 0;
        double somaValoresExecucoes = 0;


        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            ArrayList<Integer> listaNormal = new ArrayList<>();

            for(int j = 0; j < elementos; j++) {
                listaNormal.add(j);
            }

            start = System.nanoTime();
            for(int j = 0; j < consultas; j++) {
                int consulta = new Random().nextInt(0, +99_999);
                listaNormal.get(consulta);
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucoes[i] = total;
        }

        for(int i = 0; i < execucoes; i++) {
            somaValoresExecucoes += valoresExecucoes[i];
        }
        double mediaValoresExecucoesNormal = somaValoresExecucoes / execucoes;
        System.out.println("5.1 Média Lista Normal para acessar os elementos em Milissegundos: " + String.format("%.3f", mediaValoresExecucoesNormal) + " ms");

        somaValoresExecucoes = 0;

        try {
            System.gc();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < execucoes; i++) {
            LinkedList<Integer> listaEncadeada = new LinkedList<>();
            for(int j = 0; j < elementos; j++) {
                listaEncadeada.add(j);
            }
            start = System.nanoTime();
            for(int j = 0; j < consultas; j++) {
                int consulta = new Random().nextInt(0, +99_999);
                listaEncadeada.get(consulta);
            }
            end = System.nanoTime();
            total = (double) (end - start) / 1_000_000;
            valoresExecucoes[i] = total;
        }

        for(int i = 0; i < execucoes; i++) {
            somaValoresExecucoes += valoresExecucoes[i];
        }
        double mediaValoresExecucoesEncadeada = somaValoresExecucoes / execucoes;
        System.out.println("5.1 Média Lista Encadeada para acessar os elementos em Milissegundos: " + String.format("%.3f", mediaValoresExecucoesEncadeada) + " ms");

        double normal =  mediaValoresExecucoesNormal;
        double encadeada = mediaValoresExecucoesEncadeada;

        String sistemaMaisRapido = encadeada > normal ? "\nLista Normal" : "\nLista Encadeada";
        double vezesMaisRapida = encadeada > normal ? encadeada/normal : normal / encadeada;
        double porcentagemDeMelhora = (vezesMaisRapida - 1) * 100;

        System.out.println(sistemaMaisRapido + " é mais rápida e é " + String.format("%.2f", vezesMaisRapida) + " vezes mais rápida ou " + String.format("%.2f", porcentagemDeMelhora) + "%");
    }
}
