package cn.elvea.core.tree;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 树节点的值对象
 */
public class TreeNode {
    // 节点ID
    private int id;
    // 父节点ID
    private int pid;
    // 节点名称
    private String name;
    // 节点是否勾选
    private boolean checked;
    // 是否有子节点,如果值为true,那么节点展开时将会异步加载子节点
    private boolean isParent;
    // 是否禁用节点的checkbox和radio
    private boolean chkDisabled;
    // 子节点集合
    private List<TreeNode> children = Lists.newArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public boolean isChkDisabled() {
        return chkDisabled;
    }

    public void setChkDisabled(boolean chkDisabled) {
        this.chkDisabled = chkDisabled;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
