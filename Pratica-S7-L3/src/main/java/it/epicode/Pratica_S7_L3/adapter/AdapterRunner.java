package it.epicode.Pratica_S7_L3.adapter;

import java.util.Calendar;

public class AdapterRunner {
    public static void main(String[] args) {

        Info info = new Info();
        info.setNome("Mario");
        info.setCognome("Rossi");

        Calendar cal = Calendar.getInstance();
        cal.set(1990, Calendar.JANUARY, 1);
        info.DataDiNascita(cal.getTime());  // Uso il metodo DataDiNascita

        DataSource adapter = new InfoAdapter(info);

        UserData userData = new UserData();
        userData.getData(adapter);

        System.out.println("Nome completo: " + userData.getNomeCompleto());
        System.out.println("Età: " + userData.getEta());
    }
}
