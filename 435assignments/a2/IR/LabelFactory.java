package IR;

public class LabelFactory {
    private int count;

    public LabelFactory() {
        this.count = 0;
    }

    public Label getLabel() {
        Label Label = new Label(this.labelCount);
        this.count++;
        return Label;
    }
}
