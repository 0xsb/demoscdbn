/**
 * @author ldy
 */
package com.cmcc.ms.entity.system;

import java.util.List;


/**
 * 树节点支持对象，提供了从Node集合，生成TreeNode对象的方法支持.
 *
 * @author bing.peng
 */
public class TreeSupport {

    /** The Constant DEFAULT_ROOT_NAME. */
    private static final String DEFAULT_ROOT_NAME = "root";

    /** The node items. */
    private List<Node> nodeItems;

    /** The root. */
    private TreeNode root;

    /** The curr depth. */
    // 添加当前深度
    private String currDepth = "0_";

    /**
     * 根据一个节点集合，递归创建一个树结构对象 首先找出根节点对象，把自身id和自身父id相同的节点看作是根节点，找出该节点，用它创建一个根节点对象
     * 如果没有找到能表示根节点的节点，则创建一个默认的根节点对象.
     *
     * @param nodeItems the node items
     * @return the tree node
     */
    public TreeNode createTreeNode(List<Node> nodeItems) {
        this.nodeItems = nodeItems;

        for (int i = 0; i < this.nodeItems.size(); i++) {
            Node node = (Node) nodeItems.get(i);
            if (node.getId().intValue() == node.getParentId().intValue()) {
                root = new TreeNode();
                root.setId(node.getId());
                root.setName(node.getName());
                root.setResouce(node.getResouce());
                root.setParentId(node.getParentId().toString());

                this.nodeItems.remove(i);
                break;
            }
        }

        if (root == null) {
            root = new TreeNode();
            root.setId(0l);
            root.setName(DEFAULT_ROOT_NAME);
        }

        // 递归创建树结构
        create(root);

        return root;
    }

    /**
     * 根据一个节点集合，和已知根节点对象，递归创建一个树结构对象.
     *
     * @param treeNode the tree node
     * @param nodeItems the node items
     * @return the tree node
     */
    public TreeNode createTreeNode(TreeNode treeNode, List<Node> nodeItems) {
        this.nodeItems = nodeItems;
        this.root = treeNode;

        // 递归创建树结构
        create(root);

        return root;
    }

    /**
     * Creates the.
     *
     * @param treeNode the tree node
     */
    private void create(TreeNode treeNode) {
        for (Node node : nodeItems) {
            //
            if (treeNode.getId().intValue() == node.getParentId().intValue()) {
                TreeNode childrenNode = new TreeNode();
                childrenNode.setId(node.getId());
                childrenNode.setName(node.getName());
                childrenNode.setResouce(node.getResouce());
                childrenNode.setParentId(node.getParentId().toString());

                treeNode.addChildren(childrenNode);
                create(childrenNode);
            }
        }
    }

    /**
     * Creates the check box tree node.
     *
     * @param nodeItems the node items
     * @return the tree node
     */
    public TreeNode createCheckBoxTreeNode(List<Node> nodeItems) {
        this.nodeItems = nodeItems;

        for (int i = 0; i < this.nodeItems.size(); i++) {
            Node node = (Node) nodeItems.get(i);
            if (node.getId().intValue() == node.getParentId().intValue()) {
                root = new TreeNode();
                root.setId(node.getId());
                root.setName(node.getName());
                root.setResouce(node.getResouce());
                // 添加 depth
                root.setDepth(currDepth);
                //
                this.nodeItems.remove(i);
                break;
            }
        }

        if (root == null) {
            root = new TreeNode();
            root.setId(0l);
            root.setName(DEFAULT_ROOT_NAME);
            // 添加 depth
            root.setDepth(currDepth);
            //
        }

        // 递归创建树结构
        createCheckBox(root, currDepth);

        return root;
    }

    // 通过返回值可以确定当前父结点低下有没有uncheck的，0 当前父结点所有子元素都被选中;1 当前父结点所有子元素有没有被选中的;2
    /**
     * Creates the check box.
     *
     * @param treeNode the tree node
     * @param currDepth the curr depth
     * @return the int
     */
    // 当前父结点已经是最底层结点
    private int createCheckBox(TreeNode treeNode, String currDepth) {
        int counter = 1;
        int ifHaveSubNodeUnchecked = 0;
        // System.out.println("当前treeNode: " + treeNode.getName());
        for (Node node : nodeItems) {
            //
            if (treeNode.getId().intValue() == node.getParentId().intValue()) {
                TreeNode childrenNode = new TreeNode();
                childrenNode.setId(node.getId());
                childrenNode.setName(node.getName());
                childrenNode.setResouce(node.getResouce());
                childrenNode.setParentId(String.valueOf(node.getParentId()));
                childrenNode.setDepth(treeNode.getDepth() + childrenNode.getId() + "_");
                childrenNode.setChecked(((CheckedNode) node).getChecked());

                int checkReturnValue = createCheckBox(childrenNode, this.currDepth);
                // 当所有子元素有没有被选中的时候
                if (checkReturnValue == 1) {
                    // System.out.println("当前treeNode" + treeNode +
                    // "所有儿子中有没有被选中的");
                    childrenNode.setChecked(false);
                } else {
                    // 当所有子元素都被选中的时候
                    if (checkReturnValue == 0) {
                        // System.out.println("当前treeNode" + treeNode
                        // + "所有儿子中都被选中");
                        childrenNode.setChecked(true);
                    }
                }

                if (!((CheckedNode) node).getChecked()) {
                    ifHaveSubNodeUnchecked = 1;
                }
                // System.out.println("当前treeNode" + treeNode + "添加的儿子: "
                // + node.getName());
                treeNode.addChildren(childrenNode);
                counter++;
            }

        }
        // 该treeNode已经是最底层元素了
        if (counter == 1) {
            ifHaveSubNodeUnchecked = 2;
        }
        return ifHaveSubNodeUnchecked;
    }

}
