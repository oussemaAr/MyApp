package com.example.myapp.addNote;

import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddViewModel extends ViewModel {

    void getIPS() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("arp -a");
        pb.redirectErrorStream();
        Process p = pb.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder out = new StringBuilder();

        while (true) {
            String l = null;
            try {
                l = br.readLine();
            } catch (IOException ex) {
            }
            if (l == null)
                break;
            out.append("\n").append(l);
        }
        Pattern pattern = Pattern.compile(".*\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b");
        Matcher match = pattern.matcher(out.toString());

        out = new StringBuilder();
        String prev = "", pLoc;

        if (!(match.find()))
            out = new StringBuilder("No IP found!");

        else {
            pLoc = match.group();
            out.append(pLoc).append("\nOther Hosts'(In Same Network) IP addresses:\n");
            while (match.find()) {
                pLoc = match.group();
                out.append(pLoc).append("\n");
            }
            try {
                br.close();
            } catch (IOException ignored) {
            }
        }
        System.out.println(out);
    }
}

