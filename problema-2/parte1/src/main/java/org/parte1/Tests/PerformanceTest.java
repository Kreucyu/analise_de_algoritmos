package org.parte1.Tests;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceTest {
    public static void main(String[] args) {
        questaoUmTesteUm();
        questaoUmTesteDois();
    }


    private static void questaoUmTesteUm() {
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
        double mediaValoresExecucoes = somaValoresExecucoes / execucoes;
        System.out.println("1. Média Lista Normal em Milissegundos: " + String.format("%.3f", mediaValoresExecucoes) + " ms");

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
        mediaValoresExecucoes = somaValoresExecucoes / execucoes;

        System.out.println("1. Média Lista Encadeada em Milissegundos: " + String.format("%.3f", mediaValoresExecucoes) + " ms");
    }

    private static void questaoUmTesteDois() {
        int elementos = 1_000_000;
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

        double mediaValores = somaValoresExecucoes / execuoes;

        System.out.println("2. Total lista capacidade = 10: " +  String.format("%.3f", mediaValores) + " ms");

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

        mediaValores = somaValoresExecucoes / execuoes;

        System.out.println("2. Total lista capacidade = 1000: " +  String.format("%.3f", mediaValores) + " ms");

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

        mediaValores = somaValoresExecucoes / execuoes;

        System.out.println("2. Total lista capacidade = 100000: " +  String.format("%.3f", mediaValores) + " ms");
    }
}
