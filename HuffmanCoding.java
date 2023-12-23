import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}

public class HuffmanCoding {

    private static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();

            HuffmanNode internalNode = new HuffmanNode('$', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;

            minHeap.offer(internalNode);
        }

        return minHeap.poll();
    }

    private static void generateHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.data, code);
        }

        generateHuffmanCodes(root.left, code + "0", huffmanCodes);
        generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    private static String encodeMessage(String message, Map<Character, String> huffmanCodes) {
        StringBuilder encodedMessage = new StringBuilder();
        for (char ch : message.toCharArray()) {
            encodedMessage.append(huffmanCodes.get(ch));
        }
        return encodedMessage.toString();
    }

    private static String decodeMessage(String encodedMessage, HuffmanNode root) {
        StringBuilder decodedMessage = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encodedMessage.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                decodedMessage.append(current.data);
                current = root;
            }
        }

        return decodedMessage.toString();
    }

    public static void main(String[] args) {
        String message = "hello world";

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : message.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        long startTime = System.nanoTime();
        HuffmanNode root = buildHuffmanTree(frequencyMap);
        long endTime = System.nanoTime();
        long buildTime = endTime - startTime;

        Map<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);

        startTime = System.nanoTime();
        String encodedMessage = encodeMessage(message, huffmanCodes);
        endTime = System.nanoTime();
        long encodeTime = endTime - startTime;

        startTime = System.nanoTime();
        String decodedMessage = decodeMessage(encodedMessage, root);
        endTime = System.nanoTime();
        long decodeTime = endTime - startTime;

        System.out.println("Original Message: " + message);
        System.out.println("Encoded Message: " + encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
        System.out.println("Huffman Tree Build Time: " + buildTime + " ns");
        System.out.println("Encoding Time: " + encodeTime + " ns");
        System.out.println("Decoding Time: " + decodeTime + " ns");
    }
}
