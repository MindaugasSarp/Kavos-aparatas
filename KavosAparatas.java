package lt.vcs.lapkritis.mindaugas;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class KavosAparatas {
    private static final int valymoCiklas = 5;
    public int panaudojimoSkaicius = 0;
    private int cukrus;
    private int kava;
    private int vanduo;
    private int pienas;

    public KavosAparatas(int cukrus, int kava, int vanduo, int pienas) {
        this.cukrus = cukrus;
        this.kava = kava;
        this.vanduo = vanduo;
        this.pienas = pienas;
    }

    public void setKavosAparatas() {
        this.cukrus = cukrus + 5;
        this.kava = kava + 5;
        this.vanduo = vanduo + 5;
        this.pienas = pienas + 5;
    }

    public void kavosAparatoKiekiai() {
        System.out.println("Cukrus: " + this.cukrus);
        System.out.println("Kava: " + this.kava);
        System.out.println("Vanduo: " + this.vanduo);
        System.out.println("Pienas: " + this.pienas);
        System.out.println("Liko iki valymo: " + (5 - this.panaudojimoSkaicius));
    }

    private void espreso(KavosAparatas kavosAparatas) {
        cukrus = cukrus - 1;
        kava = kava - 2;
        vanduo = vanduo - 1;
        panaudojimoSkaicius++;
    }

    private void cappucino(KavosAparatas kavosAparatas) {
        cukrus = cukrus - 1;
        kava = kava - 2;
        vanduo = vanduo - 1;
        pienas = pienas - 1;
        panaudojimoSkaicius++;
    }

    private void latte(KavosAparatas kavosAparatas) {
        cukrus = cukrus - 1;
        kava = kava - 2;
        vanduo = vanduo - 1;
        pienas = pienas - 2;
        panaudojimoSkaicius++;
    }

    private void atlikPlovima() {
        this.panaudojimoSkaicius = 0;
    }

    public boolean arUztenkaIngridientu(KavosAparatas kavosAparatas) {
        if (cukrus > 1 && kava > 2 && vanduo > 1 && pienas > 1) {
            return true;
        } else return false;
    }

    public void gaminkKava(KavosAparatas kavosAparatas) {
        Scanner scanner = new Scanner(System.in);
        String arAtliktiPlovima = "Y";
        while (panaudojimoSkaicius != valymoCiklas) {
            System.out.println("Pasirinkite kavos rusi: ");
            System.out.println("A - Espreso");
            System.out.println("B - Cappucino");
            System.out.println("C - Latte");
            System.out.println("X - jeigu norite iseiti!");
            String pasrinktaKava = scanner.next();
            /*switch (pasrinktaKava) {
                case "A":
                    if (arUztenkaIngridientu()) {
                        espreso();
                        System.out.println("Skanios kavos!");
                        break;
                    } else System.out.println("papildykte aparata");
                    break;
                case "B":
                    if (arUztenkaIngridientu()) {
                        cappucino();
                        System.out.println("Skanios kavos!");
                        break;
                    } else System.out.println("papildykte aparata");
                    break;
                case "C":
                    if (arUztenkaIngridientu()) {
                        latte();
                        System.out.println("Skanios kavos!");
                        break;
                    } else System.out.println("papildykte aparata");
                    break;
                case "X":
                    break;
                default:
                    System.out.println("Blogas pasirinkimas, bandykite dar karta!");
                }
            if (pasrinktaKava.equals("X")){
                break;
            }*/
            if (pasrinktaKava.equals("A") && arUztenkaIngridientu(kavosAparatas)) {
                espreso(kavosAparatas);
                System.out.println("Skanios kavos!");
            } else if (pasrinktaKava.equals("B") && arUztenkaIngridientu(kavosAparatas)) {
                cappucino(kavosAparatas);
                System.out.println("Skanios kavos!");
            } else if (pasrinktaKava.equals("C") && arUztenkaIngridientu(kavosAparatas)) {
                latte(kavosAparatas);
                System.out.println("Skanios kavos!");
            } else if (pasrinktaKava.equals("X")) {
                break;
            } else {
                System.out.println("papildykte aparata");
                break;
            }
        }
        if (panaudojimoSkaicius == valymoCiklas) {
            System.out.println("Reikia atlikti plovima");
            System.out.println();
            System.out.println("Ar atlikti plovima? ");
            System.out.println("Paspauskite 'Y' - jeigu taip, paspauskite 'N' jeigu ne.");
            arAtliktiPlovima = scanner.next();
            if (arAtliktiPlovima.equals("Y")) {
                atlikPlovima();
                gaminkKava(kavosAparatas);
            }
        } else if (!arUztenkaIngridientu(kavosAparatas)) {
            System.out.println("Ar papildyti aparata?");
            System.out.println("Paspauskite 'Y' - jeigu taip, paspauskite 'N' jeigu ne.");
            arAtliktiPlovima = scanner.next();
            if (arAtliktiPlovima.equals("Y")) {
                setKavosAparatas();
                gaminkKava(kavosAparatas);
            }
        }

    }

    public void setCukrus(int cukrus) {
        this.cukrus = cukrus;
    }

    public void setKava(int kava) {
        this.kava = kava;
    }

    public void setPienas(int pienas) {
        this.pienas = pienas;
    }

    public void setVanduo(int vanduo) {
        this.vanduo = vanduo;
    }

    public int getPanaudojimoSkaicius() {
        return panaudojimoSkaicius;
    }

    public int getCukrus() {
        return cukrus;
    }

    public int getKava() {
        return kava;
    }

    public int getPienas() {
        return pienas;
    }

    public int getVanduo() {
        return vanduo;
    }

    public static int getValymoCiklas() {
        return valymoCiklas;
    }
}
