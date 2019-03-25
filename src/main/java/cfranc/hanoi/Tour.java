package cfranc.hanoi;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Tour implements IPile<Disque>{

	int hauteurMax = 3;
	
	Stack<Disque> disques=new Stack<>();
	
	@Override
	public boolean empiler(Disque d) {
        boolean res=false;
        if(disques.isEmpty()){
            disques.push(d);
            res=true;
        }
        else{
            if( (disques.peek().d>d.d) && (taille()<hauteurMax) ){
                res=true;
                disques.push(d);
            }
            else{
                res=false;
            }
        }
        return res;
	}

	public Tour() {
		super();
	}

	public Tour(int hauteurMax) {
		super();
		this.hauteurMax = hauteurMax;
	}

	@Override
	public Disque depiler() {
		return disques.pop();
	}

	@Override
	public Disque sommet() {	
		if (this.taille()>0){
			return disques.peek();
		}else {
			return null;
		}
	}

	@Override
	public boolean estVide() {
		return disques.isEmpty();
	}

	@Override
	public boolean estPleine() {
		if(taille() == hauteurMax){
			return true;
		}
		return false;
	}

	@Override
	public int taille() {
		return disques.size();
	}

	@Override
	public int diam() {		
		int res=Integer.MAX_VALUE;
		Disque disqueSommet = sommet();
		if(disqueSommet!=null){
			res = disqueSommet.d;
		}
		return res;
	}

}
