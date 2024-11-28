package ss6.s3;

import java.awt.*;

public class Point3D extends Point2D {

    private float z = 0.0f;

    public Point3D() {
        super(); // Gọi constructor của lớp cha
    }

    public Point3D(float x, float y, float z) {
        super(x, y); // Gọi constructor của lớp cha
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y); // Gọi phương thức setXY của lớp cha
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[]{getX(), getY(), z}; // Sử dụng getX() và getY() từ lớp cha
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }
}
