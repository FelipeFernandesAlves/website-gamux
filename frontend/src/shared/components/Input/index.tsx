import { cn } from "../../../lib/utils";

interface InputProps {
    className?: string;
    placeholder?: string;
    value?: string;
    onChange?: (value: string) => void;
}

function Input({ className, placeholder, value, onChange }: InputProps) {
    return (
        <input
            className={cn("bg-secondary text-[1.2em] text-background rounded-sm px-4 py-1.5", className)}
            placeholder={placeholder}
            value={value}
            onChange={(e) => onChange && onChange(e.target.value)}
        />
    )
}

export default Input