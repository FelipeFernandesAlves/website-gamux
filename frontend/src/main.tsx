import { BrowserRouter } from 'react-router-dom'
import { createRoot } from 'react-dom/client'
import React from 'react'

import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { AppRouter } from './router';
import "./theme.css";

const queryClient = new QueryClient()

createRoot(document.getElementById('root')!).render(
    <React.StrictMode>
      <QueryClientProvider client={queryClient} >
        <BrowserRouter>
          <AppRouter />
        </BrowserRouter>
      </QueryClientProvider>
    </React.StrictMode>
)
