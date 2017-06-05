package rectpack;
import java.util.List;
public class RectanglePacker<P> {
    private static enum Fit {
        FAIL,
        PERFECT,
        FIT
    };
    private Node root;
    private int border = 0;
    public RectanglePacker(int width, int height, int border) {
        root = new Node(new Rectangle(0, 0, width, height));
        this.border = border;
    }
    public void inspectRectangles(List<Rectangle> rectangles) {
        root.getRectangles(rectangles);
    }
    public Rectangle findRectangle(P item) {
        return root.findRectange(item);
    }
    public void clear() {
        root = new Node(root.rect);
    }
    public Rectangle insert(int width, int height, P o) {
        Node n = root.insert(width + 2 * border, height + 2 * border, o);
        if (n != null) {
            Rectangle r = new Rectangle(n.rect.x + border, n.rect.y + border,
                    n.rect.width - 2 * border, n.rect.height - 2 * border);
            return r;
        } else {
            return null;
        }
    }
    public boolean remove(P o) {
        return root.remove(o);
    }
    public int getWidth() {
        return root.rect.width;
    }
    public int getHeight() {
        return root.rect.height;
    }
    private class Node {
        private Rectangle rect;
        private P occupier = null;
        private Node left = null;
        private Node right = null;
        private Node(Rectangle r) {
            this.rect = r;
        }
        private Rectangle findRectange(P item) {
            if (isLeaf()) {
                if (item == occupier) {
                    return rect;
                } else {
                    return null;
                }
            } else {
                Rectangle l = left.findRectange(item);

                if (l != null) {
                    return l;
                } else {
                    return right.findRectange(item);
                }
            }
        }
        private Node insert(int width, int height, P o) {
            if (!isLeaf()) {
                Node r = left.insert(width, height, o);
                if (r == null) {
                    r = right.insert(width, height, o);
                }
                return r;
            } else {
                if (occupier != null) {
                    return null;
                }
                Fit fit = fits(width, height);
                switch (fit) {
                    case FAIL:
                        return null;
                    case PERFECT:
                        occupier = o;
                        return this;
                    case FIT:
                        split(width, height);
                        break;
                }
                return left.insert(width, height, o);
            }
        }
        private boolean isLeaf() {
            return left == null;
        }
        private boolean isOccupied() {
            return occupier != null || !isLeaf();
        }
        private boolean remove(P o) {
            if (isLeaf()) {
                if (occupier == o) {
                    occupier = null;
                    return true;
                }
                return false;
            } else {
                boolean found = left.remove(o);
                if (!found) {
                    found = right.remove(o);
                }
                if (found) {
                    if (!left.isOccupied() && !right.isOccupied()) {
                        left = null;
                        right = null;
                    }
                }
                return found;
            }
        }
        private void split(int width, int height) {
            int dw = rect.width - width;
            int dh = rect.height - height;
            assert dw >= 0;
            assert dh >= 0;
            Rectangle r, l;
            if (dw > dh) {
                l = new Rectangle(rect.x, rect.y, width, rect.height);

                r = new Rectangle(l.x + width, rect.y, rect.width - width,
                        rect.height);
            } else {
                l = new Rectangle(rect.x, rect.y, rect.width, height);

                r = new Rectangle(rect.x, l.y + height, rect.width, rect.height
                        - height);
            }
            left = new Node(l);
            right = new Node(r);
        }
        private Fit fits(int width, int height) {
            if (width <= rect.width && height <= rect.height) {
                if (width == rect.width && height == rect.height) {
                    return Fit.PERFECT;
                } else {
                    return Fit.FIT;
                }
            }
            return Fit.FAIL;
        }
        private void getRectangles(List<Rectangle> rectangles) {
            rectangles.add(rect);
            if (!isLeaf()) {
                left.getRectangles(rectangles);
                right.getRectangles(rectangles);
            }
        }
    }
    public static class Rectangle {
        public final int x;
        public final int y;
        public final int width;
        public final int height;
        private Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        private Rectangle(Rectangle r) {
            this.x = r.x;
            this.y = r.y;
            this.width = r.width;
            this.height = r.height;
        }
        @Override
        public String toString() {
            return "[ " + x + ", " + y + ", " + width + ", " + height + " ]";
        }
    }
    public static void main(String[] args) {
        Rectangle blocks[]={new Rectangle(0,0,100,100),new Rectangle(0,0,130,60),new Rectangle(0,0,50,120),new Rectangle(0,0,80,90),new Rectangle(0,0,40,80),new Rectangle(0,0,70,110),new Rectangle(0,0,80,80)};
        RectanglePacker packer=new RectanglePacker(300,300,0);
    }
}