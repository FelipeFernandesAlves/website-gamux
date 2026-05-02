/// <reference types="vite/client" />

// SVG module declarations for svgr plugin
declare module '*.svg?react' {
  import { ComponentType, SVGProps } from 'react';
  
  const SVG: ComponentType<SVGProps<SVGSVGElement> & { className?: string }>;
  export default SVG;
  export const ReactComponent: ComponentType<SVGProps<SVGSVGElement> & { className?: string }>;
}