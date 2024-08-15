package mars_rover.models;

public class InstructionWrapper {
    private Instruction instruction;

    public InstructionWrapper(Instruction instruction) {
        this.instruction = instruction;
    }

    public Instruction getInstruction() {
        return this.instruction;
    }
}
