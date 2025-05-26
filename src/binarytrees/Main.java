/**
 * PROJECT: Tree Functions Lab
 * NAME: Zach Harel
 * CLASS: Main - contains the main method for the binary tree lab and helper function for making tree from file
 */

package binarytrees;

import binarytrees.BinarySearchTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main() throws IOException {
        BinarySearchTree<Character> treeA = fillFromFile(Path.of("src/binarytrees/fileA.txt"));
        BinarySearchTree<Character> treeB = fillFromFile(Path.of("src/binarytrees/fileB.txt"));

        System.out.println("Tree A Preorder: " + treeA.preOrderString());
        System.out.println("Tree B Preorder: " + treeB.preOrderString());
        System.out.println("Tree A Inorder: " + treeA.inOrderString());
        System.out.println("Tree B Inorder: " + treeB.inOrderString());
        System.out.println("Tree A Postorder: " + treeA.postOrderString());
        System.out.println("Tree B Postorder: " + treeB.postOrderString());

        System.out.println("Tree A nodes: " + treeA.countNodes());
        System.out.println("Tree B nodes: " + treeB.countNodes());
        System.out.println("Tree A leaves: " + treeA.countLeaves());
        System.out.println("Tree B leaves: " + treeB.countLeaves());

        System.out.println("Tree A height: " + treeA.height());
        System.out.println("Tree B height: " + treeB.height());
        System.out.println("Tree A width: " + treeA.width());
        System.out.println("Tree B width: " + treeB.width());

        System.out.println("Tree A contains 'a': " + treeA.contains('a'));
        System.out.println("Tree B contains 'a': " + treeB.contains('a'));
        System.out.println("Tree A contains 'A': " + treeA.contains('A'));
        System.out.println("Tree B contains 'A': " + treeB.contains('A'));

        treeA.remove('A');
        treeB.remove('A');
        System.out.println("Tree A with 'A' deleted: " + treeA.inOrderString());
        System.out.println("Tree B with 'A' deleted: " + treeB.inOrderString());

        treeA.removeLeaves();
        treeB.removeLeaves();
        System.out.println("Tree A with leaves deleted: " + treeA.inOrderString());
        System.out.println("Tree B with leaves deleted: " + treeB.inOrderString());

        treeA.clear();
        treeB.clear();
        System.out.println("Tree A cleared: " + treeA.inOrderString());
        System.out.println("Tree B cleared: " + treeB.inOrderString());
    }

    public static BinarySearchTree<Character> fillFromFile(Path path) throws IOException {
        BinarySearchTree<Character> tree;
        List<String> lines = Files.readAllLines(path);
        tree = new BinarySearchTree<>(lines.getFirst().charAt(0));
        lines.set(0, lines.getFirst().substring(1));

        for (String line : lines) {
            for (char c : line.toCharArray()) {
                tree.add(c);
            }
        }

        return tree;
    }
}


/* OUTPUT:
Tree A Preorder: A C H G J E R V S O K
Tree B Preorder: A F D B H M L P N K J W T Q
Tree A Inorder: A C E G H J K O R S V
Tree B Inorder: A B D F H J K L M N P Q T W
Tree A Postorder: A C H G J E R V S O K
Tree B Postorder: A F D B H M L P N K J W T Q
Tree A nodes: 11
Tree B nodes: 14
Tree A leaves: 4
Tree B leaves: 5
Tree A height: 5
Tree B height: 6
Tree A width: 8
Tree B width: 9
Tree A contains 'a': false
Tree B contains 'a': false
Tree A contains 'A': true
Tree B contains 'A': true
Tree A with 'A' deleted: null C E G H J K O R S V
Tree B with 'A' deleted: null B D F H J K L M N P Q T W
Tree A with leaves deleted: C E G J K O S
Tree B with leaves deleted: B D H J K L N Q T
Tree A cleared: null
Tree B cleared: null
*/