package scrum.noyau;

/**
 *
 * @author Delphine
 */
public class Microplaque {

    private Sample arraySamp[];
    private String namePlate;

    public Microplaque(String name) {
        arraySamp = new Sample[8];
        namePlate = name;
    }

    /**
     * Method add sample
     *
     * @param samp : sample to add in the microplate
     */
    public void addSample(Sample samp) {
        int i = 0;
        while (arraySamp[i] != null && i < arraySamp.length) {
            i++;
        }
        arraySamp[i] = samp;
    }

    /**
     * Retourne nom de la plaquze
     * @return String : nom de la plaque
     */
    private String getName(){
        return namePlate;
    }
    /**
     *
     * @return
     */
    public Sample[] getSamples() {
        return arraySamp;
    }
}
