#!/usr/bin/env sh
set -eu

WRAPPER_DIR="$(cd "$(dirname "$0")" && pwd)/.mvn/wrapper"
PROPS_FILE="$WRAPPER_DIR/maven-wrapper.properties"

if [ ! -f "$PROPS_FILE" ]; then
  echo "Maven wrapper properties not found: $PROPS_FILE"
  exit 1
fi

DISTRIBUTION_URL="$(grep '^distributionUrl=' "$PROPS_FILE" | sed 's/distributionUrl=//')"
if [ -z "$DISTRIBUTION_URL" ]; then
  echo "distributionUrl is missing in $PROPS_FILE"
  exit 1
fi

MAVEN_BASE="${HOME}/.m2/wrapper/dists"
mkdir -p "$MAVEN_BASE"

MAVEN_ZIP_NAME="$(basename "$DISTRIBUTION_URL")"
MAVEN_VERSION="${MAVEN_ZIP_NAME%-bin.zip}"
MAVEN_HOME="${MAVEN_BASE}/${MAVEN_VERSION}"
MAVEN_CMD="${MAVEN_HOME}/bin/mvn"

if [ ! -x "$MAVEN_CMD" ]; then
  ZIP_PATH="${MAVEN_BASE}/${MAVEN_ZIP_NAME}"
  echo "Downloading Maven distribution: $DISTRIBUTION_URL"
  if command -v curl >/dev/null 2>&1; then
    curl -fsSL "$DISTRIBUTION_URL" -o "$ZIP_PATH"
  elif command -v wget >/dev/null 2>&1; then
    wget -q "$DISTRIBUTION_URL" -O "$ZIP_PATH"
  else
    echo "Neither curl nor wget is available to download Maven."
    exit 1
  fi
  unzip -oq "$ZIP_PATH" -d "$MAVEN_BASE"
  rm -f "$ZIP_PATH"
fi

if [ ! -x "$MAVEN_CMD" ]; then
  echo "Maven executable not found at $MAVEN_CMD"
  exit 1
fi

exec "$MAVEN_CMD" "$@"
