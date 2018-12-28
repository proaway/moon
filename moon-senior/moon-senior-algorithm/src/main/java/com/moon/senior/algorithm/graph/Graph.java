package com.moon.senior.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * 
 * @author TobiasCui
 * @date 2018年12月26日 上午11:49:21
 * 
 */
public class Graph {
	/** 顶点的个数 */
	private int v; //
	/** 邻接表 */
	private LinkedList<Integer> adj[]; //

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int s, int t) { // 无向图一条边存两次
		adj[s].add(t);
		adj[t].add(s);
	}

	/**
	 * 
	 * 广度优先搜索（BFS）
	 * <p>
	 * 广度优先搜索（Breadth-First-Search），我们平常都把简称为BFS。<br/>
	 * 
	 * 直观地讲，它其实就是一种“地毯式”层层推进的搜索策略，即先查找离起始顶点最近的，然后是次近的，依次往外搜索。
	 * 
	 * 这里面，bfs() 函数就是基于之前定义的，图的广度优先搜索的代码实现。其中 s 表示起始顶点，t 表示终止顶点。<br/>
	 * 
	 * 我们搜索一条从 s 到 t 的路径。实际上，这样求得的路径就是从 s 到 t 的最短路径。
	 * 
	 * <p>
	 * 掌握了广优先搜索算法的原理，我们来看下，广度优先搜索的时间、空间复杂度是多少呢？ 最坏情况下，终止顶点 t 离起始顶点 s
	 * 很远，需要遍历完整个图才能找到。这个时候，每个顶点都要进出一遍队列，每个边也都会被访问一次，所以，广度优先搜索的时间复杂度是
	 * O(V+E)，其中，V 表示顶点的个数，E 表示边的个数。当然，对于一个连通图来说，也就是说一个图中的所有顶点都是连通的，E 肯定要大于等于
	 * V-1，所以，广度优先搜索的时间复杂度也可以简写为 O(E)。
	 * 
	 * 广度优先搜索的空间消耗主要在几个辅助变量 visited 数组、queue 队列、prev
	 * 数组上。这三个存储空间的大小都不会超过顶点的个数，所以空间复杂度是 O(V)。
	 * 
	 * 
	 * @author TobiasCui
	 * @date 2018年12月26日 上午11:39:20
	 * 
	 * @param s
	 * @param t
	 */
	public void breadthFirstSearch(int s, int t) {
		if (s == t)
			return;
		/**
		 * visited是用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点 q 被访问，那相应的 visited[q]
		 * 会被设置为true。
		 */
		boolean[] visited = new boolean[v];
		visited[s] = true;
		/**
		 * queue是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。因为广度优先搜索是逐层访问的，也就是说，我们只有把第 k
		 * 层的顶点都访问完成之后，才能访问第 k+1 层的顶点。当我们访问到第 k 层的顶点的时候，我们需要把第 k
		 * 层的顶点记录下来，稍后才能通过第 k 层的顶点来找第 k+1 层的顶点。所以，我们用这个队列来实现记录的功能。
		 */
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		/**
		 * prev用来记录搜索路径。当我们从顶点 s 开始，广度优先搜索到顶点 t 后，prev
		 * 数组中存储的就是搜索的路径。不过，这个路径是反向存储的。prev[w] 存储的是，顶点 w 是从哪个前驱顶点遍历过来的。比如，我们通过顶点
		 * 2 的邻接表访问到顶点 3，那 prev[3] 就等于 2。为了正向打印出路径，我们需要递归地来打印，你可以看下 print()
		 * 函数的实现方式。
		 */
		int[] prev = new int[v];
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		while (queue.size() != 0) {
			int w = queue.poll();
			for (int i = 0; i < adj[w].size(); ++i) {
				int q = adj[w].get(i);
				if (!visited[q]) {
					prev[q] = w;
					if (q == t) {
						print(prev, s, t);
						return;
					}
					visited[q] = true;
					queue.add(q);
				}
			}
		}
	}

	private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
		if (prev[t] != -1 && t != s) {
			print(prev, s, prev[t]);
		}
		System.out.print(t + " ");
	}

	/** 全局变量或者类成员变量 */
	boolean found = false; //

	/**
	 * 深度优先搜索（Depth-First-Search），简称 DFS。最直观的例子就是“走迷宫”。
	 * 假设你站在迷宫的某个岔路口，然后想找到出口。你随意选择一个岔路口来走，走着走着发现走不通的时候，你就回退到上一个岔路口，重新选择一条路继续走，直到最终找到出口。这种走法就是一种深度优先搜索策略。<br/>
	 * 走迷宫的例子很容易能看懂，我们现在再来看下，如何在图中应用深度优先搜索，来找某个顶点到另一个顶点的路径。 你可以看我画的这幅图。搜索的起始顶点是
	 * s，终止顶点是 t，我们希望在图中寻找一条从顶点 s 到顶点 t 的路径。如果映射到迷宫那个例子，s 就是你起始所在的位置，t 就是出口。
	 * 我用深度递归算法，把整个搜索的路径标记出来了。这里面实线箭头表示遍历，虚线箭头表示回退。从图中我们可以看出，深度优先搜索找出来的路径，并不是顶点
	 * s 到顶点 t 的最短路径。
	 * 
	 * 
	 * @author TobiasCui
	 * @date 2018年12月26日 上午11:57:15
	 * 
	 * @param s
	 * @param t
	 */
	public void depthFirstSearch(int s, int t) {
		found = false;
		boolean[] visited = new boolean[v];
		int[] prev = new int[v];
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		recurDfs(s, t, visited, prev);
		print(prev, s, t);
	}

	private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
		if (found == true)
			return;
		visited[w] = true;
		if (w == t) {
			found = true;
			return;
		}
		for (int i = 0; i < adj[w].size(); ++i) {
			int q = adj[w].get(i);
			if (!visited[q]) {
				prev[q] = w;
				recurDfs(q, t, visited, prev);
			}
		}
	}

}
