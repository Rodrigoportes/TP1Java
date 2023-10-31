package utilidade;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GravacaoLog {
    private String nickName;
    private Date dataPartida;
    private String heroi;
    private String resultado;
    private String monstro;
    private int rodadas;

    public GravacaoLog(String nickName, Date dataPartida, String heroi, String resultado, String monstro, int rodadas) {
        this.nickName = nickName;
        this.dataPartida = dataPartida;
        this.heroi = heroi;
        this.resultado = resultado;
        this.monstro = monstro;
        this.rodadas = rodadas;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getHeroi() {
        return heroi;
    }

    public void setHeroi(String heroi) {
        this.heroi = heroi;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getMonstro() {
        return monstro;
    }

    public void setMonstro(String monstro) {
        this.monstro = monstro;
    }

    public int getRodadas() {
        return rodadas;
    }

    public void setRodadas(int rodadas) {
        this.rodadas = rodadas;
    }

    public void registroBatalha(GravacaoLog registro) {
        try {

            File tempDirectory = new File("temp");
            if (!tempDirectory.exists()) {
                tempDirectory.mkdirs();
            }

            FileWriter writer = new FileWriter("temp/" + registro.getNickName() + ".csv", true);

            String registroFormatado = formatarRegistro(registro);

            writer.write(registroFormatado);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatarRegistro(GravacaoLog registro) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataPartida = dateFormat.format(registro.getDataPartida());

        return dataPartida + ";" +
                registro.getHeroi() + ";" +
                registro.getResultado() + ";" +
                registro.getMonstro() + ";" +
                registro.getRodadas() + "\n";
    }

}

