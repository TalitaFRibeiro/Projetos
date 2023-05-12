 
package lp2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import static java.awt.event.KeyEvent.*;
import java.io.*;

/**
 *
 * @author Talita
 */

 
class ListFrame extends JFrame {
    
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();
    Button focus_but = null;
    Random rand = new Random();
    Figure foco = null;
    int hs=-1;
    int x,xa,y,ya = 0;
    Point p,pp = new Point(0,0);
    Point mp=new Point(0,0);
    Button botao;
    Point mouse = new Point(0,0);
    JPanel toolbox = new JPanel();
 
   
    

    ListFrame () {
        try{
           FileInputStream f = new FileInputStream("proj.bin");
           ObjectInputStream o = new ObjectInputStream(f);
           this.figs = (ArrayList<Figure>) o.readObject();
           o.close();
        
        }
        catch(Exception x){
            System.out.println("ERRO!");
        }
        
        
        this.setTitle("Projeto");
        this.setSize(350, 350);   


        

        toolbox.setBackground(Color.LIGHT_GRAY);        
        toolbox.setPreferredSize(new Dimension(80, this.getSize().height));
        this.add(toolbox,BorderLayout.WEST);
        
        Button botaoret = new Button(1,new Rect(40,60,25,25, Color.black,Color.black));
        buts.add(botaoret);
        Button botaoel = new Button(2,new Ellipse(40,110,25,25, Color.black,Color.black));
        buts.add(botaoel);
        Button botaotri = new Button(3,new Triang(40,160,25,25, Color.black,Color.black));
        buts.add(botaotri);
        Button botaotra = new Button(4,new Trapezio(40,216,25,25, Color.black,Color.black));
        buts.add(botaotra);
        Button apaga_tudo = new Button(5,new Rect(40,262,25,25, Color.white,Color.black));
        buts.add(apaga_tudo);
        
        
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
               
                    
                    
                    try{
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    }
                    catch(Exception x){
                    }
                    
                    System.exit(0);
                }
            }
        );
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent evt){
               p=evt.getPoint();
               if(p.x<=80){
                   pp.x=81;
               
               }
               else{
                   pp=p;
               }
               
               
            }
        });
                
        
     
        this.addKeyListener (
            new KeyAdapter() {
                public void keyTyped (KeyEvent evt) { 
                        
                            focus_but=null;
                            
                	switch (evt.getKeyChar()) {
                            case 'e': {
                                	int x = pp.x;
		                        int y = pp.y;
		                        int w = rand.nextInt(50);
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256), 255 );
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Ellipse e = new Ellipse(x,y, w,h,fundo,contorno);                        
		                        figs.add(e);
		                        e.print();
		                        repaint();  // outer.repaint()
		                        break;
                                        }
                            
                            case 'r':{
					int x = pp.x;
		                        int y = pp.y;
		                        int w = rand.nextInt(50);
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Rect r = new Rect(x,y, w,h,fundo,contorno);                       
		                        figs.add(r);
		                        r.print();
		                        repaint();  // outer.repaint()                                        
		                        break;
                                    }
                            
		            case 't':{
		                        int x = pp.x;
		                        int y = pp.y;
		                        int h = rand.nextInt(50);
		                        int w = rand.nextInt(55) + 15;
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Triang t = new Triang(x,y, w,h,fundo,contorno);                         
		                        figs.add(t);
		                        t.print();
		                        repaint();  // outer.repaint()
		                        break;
		                        }
                                  
		            case 'c' :{
		                        int x = pp.x;
		                        int y = pp.y;
		                        int w = rand.nextInt(100);
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Trapezio c = new Trapezio(x,y, w,h,fundo,contorno);                       
		                        figs.add(c);
		                        c.print();
		                        repaint(); // outer.repaint()
                                        break;     
                                    
		                 }
                                 
                            case 'm':{
                                     
                                        if(foco!=null){
                                            foco.mudarcordefundo();
                                            repaint();
                                        }
                                        break;
                                 }

                            case 'l':{
                                     
                                        if(foco!=null){
                                            foco.mudarcordecontorno();
                                            repaint();
                                        }

                                        break;
                                }
                                 
                            case VK_DELETE :{
                                         if(foco!=null){
                                            figs.remove(foco);
                                            foco=null;
                                            repaint();
                                        }
                                                                          
                                        break;
                                 }                                 
			}
                    
                }    
                public void keyPressed (KeyEvent evt){
                    switch(evt.getKeyCode()){                        
                      
                        case 37:{//LEFT
                            
                            if(foco!=null){
                                foco.drag( -10,0);
                                repaint();                                                                                  
                                }
                                          
                            break;
                        }
                    
                        case 38 :{//UP
                            
                            if(foco!=null){
                                foco.drag(0,-10);
                                repaint();                                                                                                                   
                            }
                                         
                            break;                       
                        }
                        case 39:{ //RIGHT
                            
                            if(foco!=null){
                                foco.drag(10,0);                                            
                                repaint();
                            }
                                        
                            break;
                        }
                        
                        case 40:{//DOWN
                            
                                if(foco!=null){
                                   foco.drag(0,+10);
                                   repaint();
                                 }
                                   
                            break;                            
                        }
                        
                        case KeyEvent.VK_TAB:{
                                                                 
                               if(foco!=null){ 
                                    foco=figs.get(0);
                                    repaint();
                                }
                                                        
                            break;                      
                        }
                        case KeyEvent.VK_ESCAPE:{//ESC
                            foco=null;
                            focus_but=null;
                            repaint();
                            break;
                        }
                        
                        case (KeyEvent.VK_ADD):{// + do Numpad
                                                           
                               if(foco!=null){ 
                                   foco.settSize( + 10,  + 10,8);
                                   repaint();
                               }
                            
                            break;
                            }    
                        
                        case (KeyEvent.VK_SUBTRACT):{// - do Numpad
                                            
                               if(foco!=null){ 
                                   foco.settSize(- 10,  - 10,8);
                                   repaint();
                               }
                            
                            break;
                            
                         }
                
                    }
                }
            }
      );
        
        this.addMouseListener(new MouseAdapter() {
             public void mouseClicked (MouseEvent evt){
               	x= evt.getX();
                y= evt.getY();
                
               
                if(toolbox.contains(x, y)==true){
                  for(Button but:buts){
                    if(but.clicked(x, y)){
                        focus_but= but;
                        repaint();
                        break;
                    }
                    else{
                        
                        focus_but=null;
                        
                        repaint();
                    }
                    
                }
               
                    

                
                }
                else{ 
                    
                    xa=x;
                    ya=y;
                    repaint();
            	for(int i = figs.size()-1;i>=0;i--) {
                    if(figs.get(i).clicked(x, y)){ 
                        foco = figs.get(i);
                        focus_but=null;
                        repaint();                        
                        break;
                        }
                    
                    
                    else{
                        foco=null;
                        repaint();
                        
                    }
            	 }
                    

                   
              
                }
           }  
             public void mousePressed(MouseEvent evt){
                               
                 if(foco!=null){
                        mp= evt.getPoint();
                        hs=foco.handlerizar(mp);
                        if(toolbox.contains(mp)==false){
                        
                        if((!((mp.x >= foco.get("x")) && (mp.x<=((foco.get("x"))+(foco.get("w")))) && ((mp.y>= foco.get("y")) && (mp.y<=(foco.get("y")) + (foco.get("h"))))))&&(hs==-1)){
                                foco=null;
                                repaint();
                        }
                    }
                }
             }
        });

        this.addMouseMotionListener(new MouseMotionAdapter(){
              public void mouseDragged( MouseEvent evt){
                 
                  mouse = evt.getPoint();
                    if(toolbox.contains(mouse)==false){
                        if(foco!=null){

                                if(hs!=-1){
                                    
                                    foco.settSize(mouse.x - mp.x, mouse.y - mp.y,hs);
                                    mp=mouse;
                                    repaint();  
                                }
                                else{
                                    
                                    foco.drag(mouse.x - mp.x , mouse.y - mp.y);
                                    mp=mouse;
                                    repaint();
                                    
                                }
                        
                    }
                        
              }  
                  }
              });


//        this.setTitle("Projeto");
//        this.setSize(350, 350);        
   }


    public void paint (Graphics g) {    
        super.paint(g);
        for(Button but : buts){
            
                but.paint(g,false);
            
        }
        if(focus_but!=null){
            focus_but.paint(g, true);
            if((xa!=0)&&(ya!=0)){
                figs.add(focus_but.Create_figurebtn(xa, ya));
                xa=0;
                ya=0;
            }
            if(focus_but.idx==5){
                 figs= focus_but.limpar_tudo(figs);
                 
            }
            
            
            
        }
        
        if(figs.size()>=1){
        for (Figure fig: figs) {
            
                fig.paint(g,false);
              
            
           
        }
        
        
        if(foco!=null){
            figs.remove(foco);
            figs.add(foco);
            foco.paint(g,true);
            
        }
        
      } 
       
    }
}
