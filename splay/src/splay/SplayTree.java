package splay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class SplayTree<SplayKey extends Comparable<SplayKey>, SplayValue extends Comparable<SplayValue>> {
	private Node root;
	private Node rootFind;
	private int removeCount = 0;
	private int sizeCount = 0;
	private long _size = 1;
	private int countName = 0;
	private ArrayList<String> nameArr = new ArrayList<String>();
	private ArrayList<String> valueArrPop = new ArrayList<String>();

	public SplayTree() {
		root = null;
	}

	class Node {

		public SplayKey key; // The key in the node
		public SplayValue value;

		Node(SplayKey theKey, SplayValue theValue, String name, int valueNum) {

			key = theKey;
			value = theValue;
			left = right = null;

		}

		Node left;
		Node right;

	}
	
	public void insertNameArr(String name) {
		nameArr.add(name); 
	}

	public int insert(SplayKey key, SplayValue value) {

		Node n;
		Node b;
		int c;
		b = new Node(key, value, null, 0);

		if (root == null) {
			root = new Node(key, value, null, 0);
			return 1;
		}

		root = splayNode(root, key, null, true, 0);

		if ((c = key.compareTo(root.key)) == 0) {

			return 0;
		}

		n = new Node(key, value, null, 0);
		if (c < 0) {
			n.left = root.left;
			n.right = root;
			root.left = null;
		} else {
			n.right = root.right;
			n.left = root;
			root.right = null;
		}
		root = n;
		_size++;

		return 1;
	}
	
	
	public SplayKey remove(SplayValue value) {
		Node x;
		SplayKey returnInt;
		root = splayNode(root, value, true);

		if (!(root.value.equals(value))) {
			System.out.println("No such record found");
// throw new ItemNotFoundException(x.toString());
			return null;
		}
		returnInt = root.key;

		if (root.left == null) {
			root = root.right;
		} else {
			x = root.right;
			root = root.left;
			root = splayNode(root, value, true);
			root.right = x;
		}
		_size--;

		return returnInt;
	}

// public int sizeHandler(Node<SplayKey, SplayValue> head) {
//
// Node<SplayKey, SplayValue> x = head;
// if (x == null)
// return sizeCount;
// sizeCount++;
// sizeHandler(head.left);
// sizeHandler(head.right);
// return sizeCount;
// }

// public SplayValue findMin() {
// Node<SplayKey, SplayValue> x = root;
// if (root == null)
// return null;
// while (x.left != null)
// x = x.left;
// splay(x.key);
// return x.value; // Modified
// }

// public SplayValue findMax() {
// Node<SplayKey, SplayValue> x = root;
// if (root == null)
// return null;
// while (x.right != null)
// x = x.right;
// splay(x.key);
// return x.value; // Modified
// }

	public SplayKey find(SplayValue value) {

		if (root == null)
			return null;
		root = splayNode(root, value, true);
//    splayFind(value);
		int compareTheValue = value.compareTo(root.value);
		if (compareTheValue == 0) {
			return root.key;
		} else {
			return null;
		}
// if (root.value.equals(value) || rootFind.value.equals(value)) {
// System.out.println("Record  Found");
// return root.key;
// } else {
// System.out.println("Record Not Found");
// }
//return root.key;
	}

	public SplayKey findListKey(SplayValue value) {

		if (root == null)
			return null;
		root = splayNode(root, value, true);
		int compareTheValue = value.compareTo(root.value);
		if (compareTheValue == 0) {
			return root.key;
		} else {
			return null;
		}
	}

	public SplayValue findList(SplayKey value) {

		if (root == null)
			return null;

		root = splayNode(root, value, null, true, 0);

		int compareTheValue = value.compareTo(root.key);
		if (compareTheValue == 0) {
			return root.value;
		} else {
			return null;
		}

	}

	public boolean search(SplayValue value) {

		if (root == null)
			return false;
		root = splayNode(root, value, true);
		if (root.value.equals(value)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void makeEmpty() {
		root = null;
	}

// private void moveToRoot(SplayKey key) {
// Node<SplayKey, SplayValue> l, r, t, y;
// l = r = header;
// t = root;
// header.left = header.right = null;
// for (;;) {
// if (key.compareTo(t.key) < 0) {
// if (t.left == null)
// break;
// r.left = t; /* link right */
// r = t;
// t = t.left;
// } else if (key.compareTo(t.key) > 0) {
// if (t.right == null)
// break;
// l.right = t; /* link left */
// l = t;
// t = t.right;
// } else {
// break;
// }
// }
// l.right = t.left; /* assemble */
// r.left = t.right;
// t.left = header.right;
// t.right = header.left;
// root = t;
// }

// private static Node header = new Node(null, null); // For splay //Modified

	private void splayFind(SplayValue value) {
		rootFind = root;
		splayNode(rootFind, value, true);
	}

	public Node splayNode(Node root, SplayKey keyOfSplay, String name, Boolean flag, int count) {

		if (flag) {
			if (root == null)
				return null;

			int comparekeyOfSplay = 0;

			comparekeyOfSplay = keyOfSplay.compareTo(root.key);

			if (comparekeyOfSplay < 0) {

				if (root.left == null) {
					return root;
				}

				if (count == 0) {
					int comparekeyOfSplay2 = keyOfSplay.compareTo(root.left.key);
					if (comparekeyOfSplay2 > 0) {

						root.left.right = splayNode(root.left.right, keyOfSplay, name, flag, count);
						if (root.left.right != null)
							root.left = splayRotateLeft(root.left, flag);

					} else if (comparekeyOfSplay2 < 0) {
						root.left.left = splayNode(root.left.left, keyOfSplay, name, flag, count);
						root = splayRotateRight(root, flag);
					}

					if (root.left == null) {
						return root;
					} else {
						return splayRotateRight(root, flag);
					}
				}
			}

			else if (comparekeyOfSplay > 0) {

				if (root.right == null) {
					return root;
				}

				int comparekeyOfSplay2 = keyOfSplay.compareTo(root.right.key);
				if (comparekeyOfSplay2 > 0) {
					root.right.right = splayNode(root.right.right, keyOfSplay, name, flag, count);
					root = splayRotateLeft(root, flag);

				} else if (comparekeyOfSplay2 < 0) {

					root.right.left = splayNode(root.right.left, keyOfSplay, name, flag, count);
					if (root.right.left != null)
						root.right = splayRotateRight(root.right, flag);
				}

				if (root.right == null) {
					return root;
				} else {
					return splayRotateLeft(root, flag);
				}

			}

			else
				return root;
		}
		return null;
	}

	private Node splayNode(Node root, SplayValue valueofSplay, Boolean flag) {

		if (flag) {

			if (root == null)
				return null;
			int campareTheValue = 0;

// System.out.println("CampareTheValue" + campareTheValue);

			campareTheValue = valueofSplay.compareTo(root.value);

			if (campareTheValue < 0) {

				if (root.left == null) {
					return root;
				}
				int campareTheValue2 = 0;
				campareTheValue2 = valueofSplay.compareTo(root.left.value);

				if (campareTheValue2 > 0) {
					root.left.right = splayNode(root.left.right, valueofSplay, flag);
					if (root.left.right != null)
						root.left = splayRotateLeft(root.left, flag);

				} else if (campareTheValue2 < 0) {
					root.left.left = splayNode(root.left.left, valueofSplay, flag);
					if (root.left.left == null) {
//
					}
					root = splayRotateRight(root, flag);
				}

				if (root.left == null) {
					if (root.right == null) {
//
					}
					return root;
				} else
					return splayRotateRight(root, flag);
			}

			else if (campareTheValue > 0) {

				int campareTheValue2 = 0;
				if (root.right == null) {
					return root;
				}

				campareTheValue2 = valueofSplay.compareTo(root.right.value);

				if (campareTheValue2 > 0) {
					root.right.right = splayNode(root.right.right, valueofSplay, flag);
					root = splayRotateLeft(root, flag);

					if (root.right.right == null) {
//
					}

				} else if (campareTheValue2 < 0) {
					if (flag == true) {
						root.right.left = splayNode(root.right.left, valueofSplay, flag);

						if (root.right.left != null)
							root.right = splayRotateRight(root.right, flag);

					}
				}
				if (root.right == null) {
					if (root.right.left == null) {
//
					}
					return root;
				} else {
					return splayRotateLeft(root, flag);
				}
			}

			else
				return root;
		}
		return null;
	}

	private Node splayRotateRight(Node h, Boolean flag) {
		if (flag) {
			Node x = h.left;
			h.left = x.right;
			x.right = h;
			return x;
		}
		return null;
	}

// left rotate
	private Node splayRotateLeft(Node h, Boolean flag) {

		if (flag) {
			Node x = h.right;
			h.right = x.left;
			x.left = h;
			return x;
		}

		return null;
	}

// public void inorder() {
// inorder(root);
// }
//
// private void inorder(Node r) {
// if (r != null) {
// inorder(r.left);
// System.out.print(r.value + " ");
////            System.out.print(r.key+" "+ r.net+" "+ r.value +" ");
// inorder(r.right);
// }
// }
//
// public void preorder() {
// preorder(root);
// }
//
// private void preorder(Node r) {
// if (r != null) {
// System.out.print(r.value + " ");
////        System.out.print(r.key+" "+ r.net+" "+ r.value +" ");
// preorder(r.left);
// preorder(r.right);
// }
// }

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node r) {
//    ArrayList<String> returnArray = new ArrayList(); 
		if (r != null) {
			int dep = depth(r);
			postorder(r.left);
			postorder(r.right);
			for (int i = 0; i < dep; i++) {
//				System.out.print(" ");
				valueArrPop.add("_");
			}

//            returnArray.add(r.key+ " " +r.value);
// System.out.print(r.value + " ");
// System.out.println();

			String value = "" + r.value;
// System.out.println(value);
			valueArrPop.add(value);

		}
// return returnArray;

	}

	public void emptyList() {
		valueArrPop.clear();
	}

	public int depth(Node r) {
		if (r == null) {
			return 0;
		}
		int ln = depth(r.left);
		int rn = depth(r.right);
		return Math.max(ln, rn) + 1;
	}

	public void display(Node r) {
		int dep = depth(r);
		if (r != null) {
			for (int i = 0; i < dep; i++) {
				System.out.print(" ");
				valueArrPop.add("_");
			}
			System.out.println("");
			valueArrPop.add("_");
		}
	}

// test code
	public static void main(String[] args) {
		System.out.println("Enter Command:");
		SplayTree<Integer, Integer> t = new SplayTree<Integer, Integer>();
		SplayTree<Integer, Integer> t1 = new SplayTree<Integer, Integer>();
		SplayTree<Integer, Integer> t2 = new SplayTree<Integer, Integer>();

		Scanner scan1 = new Scanner(System.in);
		int i = 0;

		while (scan1.hasNext()) {
			try {
				String sOperation = scan1.next();

// System.out.println(sOperation);
				if (sOperation.compareTo("insert") == 0) {
					i++;
					int pop = scan1.nextInt();
					int net = scan1.nextInt();
					String name = scan1.next();
					ArrayList<String> nameArrSearch = t2.nameArr;
					int indexSearch = nameArrSearch.indexOf(name);
					if (!(Character.isDigit(name.charAt(0)))) {
						if (!(t.search(pop)) && !(t1.search(net)) && !(t2.search(indexSearch))) {
							int count = 0;
							count += t.insert(i, pop);
							count += t1.insert(i, net);
							t2.insertNameArr(name);
							ArrayList<String> nameArr = t2.nameArr;
							int index = nameArr.indexOf(name);
							count += t2.insert(i, index);
							if (count == 3) {
								System.out.println("Insert Successful");
							}
						} else {
							System.out.println("Insert Unsuccessful");
						}
					} else {
						System.out.println("Insert Unsuccessful");
					}

				} else if (sOperation.compareTo("find") == 0) {
					int field = scan1.nextInt();
					if (field == 1) {
						int fieldValue = scan1.nextInt();
						int key = t.find(fieldValue);
						
						
                        int nameNumb = t2.findList(key);
						
						ArrayList<String> nameArr = t2.nameArr;
						
						String nameIndex = nameArr.get(nameNumb);
						
						
						System.out.println(
								"The record is: " + fieldValue + " " + t1.findList(key) + " " + nameIndex);

					} else if (field == 2) {
						int fieldValue = scan1.nextInt();
						int key = t1.find(fieldValue);
						
						int nameNumb = t2.findList(key);
						
						ArrayList<String> nameArr = t2.nameArr;
						
						String nameIndex = nameArr.get(nameNumb);
						
						
						System.out.println(
								"The record is: " + t.findList(key) + " " + fieldValue + " " + nameIndex );

					} else if (field == 3) {
						String fieldValue = scan1.next();
						ArrayList<String> nameArr = t2.nameArr;
						int index = nameArr.indexOf(fieldValue);
						int key = t2.find(index);
						System.out.println(
								"The record is: " + t.findList(key) + " " + t1.findList(key) + " " + fieldValue);

					}

				} else if (sOperation.compareTo("remove") == 0) {
					int field = scan1.nextInt();
					if (field == 1) {

						int key = t.remove(scan1.nextInt());

						if (key >= 0) {
// int eco = t1.splayFind(key);
							int eco = t1.findList(key);
							t1.remove(eco);

// String name = t2.splayFind(key);
							int name = t2.findList(key);
							t2.remove(name);
							
							System.out.println("Successful");

						}
						else {
							System.out.println("Unsuccessful");
						}
						

					} else if (field == 2) {
						int key = t1.remove(scan1.nextInt());

						if (key >= 0) {
// int pop = t.splay(key);
							int pop = t.findList(key);
							t.remove(pop);

// String name = t2.splay(key);
							int name = t2.findList(key);
							t2.remove(name);
							
							System.out.println("Successful");

						}
						else {
							System.out.println("Unsuccessful");
						}

					} else if (field == 3) {
						String fieldValue = scan1.next();
						ArrayList<String> nameArr = t2.nameArr;
						int index = nameArr.indexOf(fieldValue);
						int key = t2.remove(index);

						if (key >= 0) {
// int pop = t.splay(key);
							int pop = t.findList(key);
							t.remove(pop);

// int eco = t1.splay(key);
							int eco = t1.findList(key);
							t1.remove(eco);
							System.out.println("Successful");
						}
						else {
							System.out.println("Unsuccessful");
						}

					}
//
				} else if (sOperation.compareTo("makenull") == 0) {
					t.makeEmpty();
					t1.makeEmpty();
					t2.makeEmpty();

				} else if (sOperation.compareTo("list") == 0) {
					int field = scan1.nextInt();

					String fieldStr = Integer.toString(field);

					String pop = "1";
					String eco = "2";
					String name = "3";

					if (fieldStr.equals(pop)) {
						t.postorder();

						ArrayList<String> a = t.valueArrPop;
// Collections.sort(a);

//      a.forEach((n) -> 
//     System.out.println(n));

						for (String data : a) {
							if (data != "_") {
								int key = t.findListKey(Integer.parseInt(data));
								
								int nameNumb = t2.findList(key);
								ArrayList<String> nameArr = t2.nameArr;
								String getName = nameArr.get(nameNumb);
//     System.out.println("");
								System.out.print(data + " " + t1.findList(key) + " " + getName);
								System.out.println();
//     System.out.println(" " + t1.findList(key) + " " + t2.findList(key) );
							} else {
								System.out.print(" ");
							}

						}

						t.emptyList();

					}

					if (fieldStr.equals(eco)) {

						t1.postorder();

						ArrayList<String> a = t1.valueArrPop;
// Collections.sort(a);

//      a.forEach((n) -> 
//     System.out.println(n));

						for (String data : a) {
							if (data != "_") {
								int key = t1.findListKey(Integer.parseInt(data));
								
								int nameNumb = t2.findList(key);
								ArrayList<String> nameArr = t2.nameArr;
								String getName = nameArr.get(nameNumb);
//     System.out.println("");
								System.out.print(t.findList(key) + " " + data + " " + getName);
								System.out.println();
//     System.out.println(" " + t1.findList(key) + " " + t2.findList(key) );
							} else {
								System.out.print(" ");
							}

						}

						t1.emptyList();

					}

					if (fieldStr.equals(name)) {
						t2.postorder();

						ArrayList<String> a = t2.valueArrPop;
// Collections.sort(a);

//      a.forEach((n) -> 
//     System.out.println(n));

						for (String data : a) {
							if (data != "_") {
								
//								String fieldValue =data;
//								ArrayList<String> nameArr = t2.nameArr;
//								int index = nameArr.indexOf(fieldValue);
					
								
								int key = t2.findListKey(Integer.parseInt(data));
								
								int nameNumb = t2.findList(key);
								ArrayList<String> nameArr = t2.nameArr;
								String getName = nameArr.get(nameNumb);
//								System.out.println(
//										"The record is: " + t.findList(key) + " " + t1.findList(key) + " " + fieldValue);
//     System.out.println("");
// t.findList(key);
// t1.findList(key);
								System.out.print(t.findList(key) + " " + t1.findList(key) + " " + getName);
								System.out.println();
//     System.out.println(" " + t1.findList(key) + " " + t2.findList(key) );
							} else {
								System.out.print(" ");
							}

						}

						t1.emptyList();
						a.removeAll(a);
						t1.valueArrPop.removeAll(t1.valueArrPop);
					}

				}

			} catch (Exception e) {
				System.out.println("enter properly");
			}
		}

	}
}