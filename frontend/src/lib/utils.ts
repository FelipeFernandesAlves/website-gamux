import clsx, { type ClassValue } from 'clsx';
import { twMerge } from 'tailwind-merge';

/**
 * Combines class names with Tailwind CSS merging.
 * @param inputs The class names to combine.
 * @returns The combined class names.
 */
export function cn(...inputs: ClassValue[]): string {
  return twMerge(clsx(inputs));
}

export function formatStringName(name: string): string {
  return name.toLowerCase().replace(/\s+/g, '-');
}

export function formatDatetime(datetime: string) {
  return datetime
}