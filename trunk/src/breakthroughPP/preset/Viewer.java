package breakthroughPP.preset;

public interface Viewer {
    int turn();
    
    int getDimX();
    
    int getDimY();
    
    int getColor(int letter, int number);
    
    Status getStatus();
}
