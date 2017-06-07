package utility;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	public Graph(Integer id) {
		this.id = id;
	}
	
	private Integer id;
	private List<Next> next; // <child, weight>
	
	public Integer getId() {
		return id;
	}

	public List<Next> getNext() {
		if(next == null)
			next = new ArrayList<Next>();
		return next;
	}

	public void setNext(Graph grafo, int peso) {
		if(next == null)
			next = new ArrayList<Next>();
		
		Next next = new Next();
		next.setNext(grafo);
		next.setPeso(peso);
		
		this.next.add(next);
	}

	@Override
	public String toString() {
		return String.valueOf(this.id);
	}
	
	public static Graph getGrafo() {
		Graph grafo1 = new Graph(1);
		Graph grafo2 = new Graph(2);
		Graph grafo3 = new Graph(3);
		Graph grafo4 = new Graph(4);
		Graph grafo5 = new Graph(5);
		Graph grafo6 = new Graph(6);
		Graph grafo7 = new Graph(7);
		Graph grafo8 = new Graph(8);
		Graph grafo9 = new Graph(9);
		Graph grafo10 = new Graph(10);
		Graph grafo11 = new Graph(11);
		Graph grafo12 = new Graph(12);
		Graph grafo13 = new Graph(13);
		Graph grafo14 = new Graph(14);
		Graph grafo15 = new Graph(15);
		Graph grafo16 = new Graph(16);
		Graph grafo17 = new Graph(17);
		Graph grafo18 = new Graph(18);
		Graph grafo19 = new Graph(19);
		Graph grafo20 = new Graph(20);
		Graph grafo21 = new Graph(21);
		Graph grafo22 = new Graph(22);
		Graph grafo23 = new Graph(23);
		Graph grafo24 = new Graph(24);
		Graph grafo25 = new Graph(25);
		Graph grafo26 = new Graph(26);
		Graph grafo27 = new Graph(27);
		Graph grafo28 = new Graph(28);
		Graph grafo29 = new Graph(29);
		Graph grafo30 = new Graph(30);

		grafo1.setNext(grafo2, 4);
		grafo1.setNext(grafo3, 3);
		
		grafo2.setNext(grafo4, 7);
		
		grafo3.setNext(grafo9, 6); 
		grafo3.setNext(grafo11, 4);
		
		grafo4.setNext(grafo5, 2);
		grafo4.setNext(grafo7, 7);
		
		grafo5.setNext(grafo8, 9);
		
		grafo6.setNext(grafo10, 5);
		
		//grafo7.next
		
		grafo8.setNext(grafo10, 9);
		
		grafo9.setNext(grafo4, 1);
		grafo9.setNext(grafo11, 5);
		grafo9.setNext(grafo13, 3);
		
		grafo10.setNext(grafo17, 4);
		grafo10.setNext(grafo12, 9);
		
		grafo11.setNext(grafo13, 10);
		grafo11.setNext(grafo16, 5);
		
		grafo12.setNext(grafo17, 5);
		grafo12.setNext(grafo24, 9);
		grafo12.setNext(grafo27, 7);
		
		
		grafo13.setNext(grafo6, 2);
		grafo13.setNext(grafo14, 4);
		grafo13.setNext(grafo15, 7);
		grafo13.setNext(grafo16, 3);
		grafo13.setNext(grafo18, 1);
		
		grafo14.setNext(grafo15, 5);
		grafo14.setNext(grafo18, 5);
		
		grafo15.setNext(grafo23, 1);
		
		grafo16.setNext(grafo21, 2);
		
		//grafo17.next
		
		grafo18.setNext(grafo19, 9);
		grafo18.setNext(grafo20, 6);
		
		//grafo19.next
		
		grafo20.setNext(grafo22, 1);
		grafo20.setNext(grafo28, 6);
		
		grafo21.setNext(grafo20, 4);
		
		grafo22.setNext(grafo23, 3);
		
		grafo23.setNext(grafo25, 7);
		
		grafo24.setNext(grafo26, 3);
		
		grafo25.setNext(grafo26, 1);
		grafo25.setNext(grafo30, 5);
		
		//grafo26.next
		
		grafo27.setNext(grafo23, 2);
		
		grafo28.setNext(grafo29, 4);
		
		grafo29.setNext(grafo30, 4);
		
		//grafo30.next
		
		return grafo1;
	}
	
	public class Next {
		
		private Graph next;
		private int peso;
		
		@Override
		public String toString() {
			return String.valueOf(next.id);
		}
		
		public Graph getNext() {
			return next;
		}
		public void setNext(Graph next) {
			this.next = next;
		}
		public int getPeso() {
			return peso;
		}
		public void setPeso(int peso) {
			this.peso = peso;
		}
	}
	
}
