import { __assign } from "tslib";
import { name, version } from "./package.json";
import { Sha256 } from "@aws-crypto/sha256-browser";
import { FetchHttpHandler, streamCollector } from "@aws-sdk/fetch-http-handler";
import { invalidFunction } from "@aws-sdk/invalid-dependency";
import { parseUrl } from "@aws-sdk/url-parser-browser";
import { fromBase64, toBase64 } from "@aws-sdk/util-base64-browser";
import { calculateBodyLength } from "@aws-sdk/util-body-length-browser";
import { defaultUserAgent } from "@aws-sdk/util-user-agent-browser";
import { fromUtf8, toUtf8 } from "@aws-sdk/util-utf8-browser";
import { ClientSharedValues } from "./runtimeConfig.shared";
export var ClientDefaultValues = __assign(__assign({}, ClientSharedValues), {
  runtime: "browser",
  base64Decoder: fromBase64,
  base64Encoder: toBase64,
  bodyLengthChecker: calculateBodyLength,
  credentialDefaultProvider: invalidFunction("Credential is missing"),
  defaultUserAgent: defaultUserAgent(name, version),
  regionDefaultProvider: invalidFunction("Region is missing"),
  requestHandler: new FetchHttpHandler(),
  sha256: Sha256,
  streamCollector: streamCollector,
  urlParser: parseUrl,
  utf8Decoder: fromUtf8,
  utf8Encoder: toUtf8,
});
//# sourceMappingURL=runtimeConfig.browser.js.map
