#!/bin/bash

# Add all new and modified files
git add .

# Commit with a timestamp message
git commit -m "Daily DSA update: $(date)"

# Push to GitHub
git push origin main

