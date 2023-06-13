
import java.util.*;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
public class MAZE_SOLVER extends JFrame{

    private int [][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,0},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public List<Integer> path = new ArrayList<>();
    
    public MAZE_SOLVER() {
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //DFS.searchpath(maze,1,1,path);
        System.out.println(path);

    }

    @Override
    public void paint(Graphics g) {
        for(int i=0; i<maze.length; i++) {
            for (int j=0;j<maze[0].length;j++) {
                Color color;
                switch(maze[i][j]) {
                    case 1: 
                        color=Color.BLACK;
                        break;
                    case 9: 
                        color=Color.RED; 
                        break;
                    default: 
                        color = Color.WHITE; 
                        break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(Color.RED);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }

        for(int i=0; i<path.size(); i+=2) {
            int pathx = path.get(i);
            int pathy = path.get(i+1);

            System.out.println("X coordinates" + pathx);
            System.out.println("Y coordinates" + pathy);
            g.setColor(Color.GREEN);
            g.fillRect(30*pathx, 30*pathy, 20, 30);
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        MAZE_SOLVER view = new MAZE_SOLVER();
        view.setVisible(true);
    }
}
