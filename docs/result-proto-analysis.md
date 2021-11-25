# String Concatenation Analysis

## Method

Input comes from this article:
[Oracle sets its own JDK free, sort of, for a while](https://www.theregister.com/2021/09/16/oracle_jdk_free_license/)

Input has 94 lines, 883 words, and 5471 charactes (after manual intervention).

Do 10 tries with different implementations, use 'real' field in `time`:

- StringBuilder
  - avg 0.1915 s
  - min 0.179 s
  - max 0.209 s
- StringBuffer
  - avg 0.2008 s
  - min 0.189 s
  - max 0.224 s
- String
  - avg 0.2284 s
  - min 0.210 s
  - max 0.256 s

The entire script of benchmark:

```bash
#!/bin/bash

# fail fast
set -e

./build.sh

# source: https://www.theregister.com/2021/09/16/oracle_jdk_free_license/
_dargs='
Oracle this week made Oracle JDK "available for free," for personal, commercial and
production use, including quarterly security updates, for a limited time.

"Free" in this context means the software is now licensed under the Oracle No-Fee Terms
and Conditions (NFTC) license, having been previously under the Oracle Technology
Network (OTN) License Agreement for Oracle Java SE.

But "free" does not mean developers may do as they please. Oracle''s NFTC forbids
redistribution of its Java software for a fee.

"Free" also does not mean the NFTC license conforms with the Free Software Definition
or the Open Source Definition, both of which require allowing fee-based distribution.

"Even though it is ''free to use'' - although not really totally free to use, since
commercial use isn''t free to use - that is extremely different from Free Software and
Open Source," said Jim Jagielski, an open source veteran who helped co-found the Apache
Software Foundation and now oversees open source at Salesforce.

"It is still a proprietary implementation, and although you are allowed to use it,
you get none of the other freedoms normally associated with open source. When truly
free/open source alternatives exist, what exactly is the incentive to use Oracle''s version?"

In a blog post, Donald Smith, senior director of product management at Oracle, described
the license shift as a response to feedback after the Oracle OpenJDK was put under
the GPL and customers said they "wanted the trusted, rock-solid Oracle JDK under an
unambiguously free terms license, too."

OpenJDK is open source, under the JDK Project, and serves as a reference implementation
for Oracle''s commercially-oriented Java Platform, Standard Edition Development Kit (JDK).
The Oracle JDK, which just reached version 17, is similar to the OpenJDK but not identical.
The Oracle JDK includes various optional features and components like installers that may
require payment.

The NFTC license has a limited lifespan. "LTS [Long-Term Support] releases,
such as JDK 17, will receive updates under this license for one year after the release of
the subsequent LTS," Oracle explains in its FAQs. "After the free use license period,
Oracle intends to use the OTN License, the same currently used for Java 8 and 11 LTS releases,
for subsequent updates."

With JDK 21 (LTS) due in September 2023, that means JDK 17 (LTS)
users will see their NFTC license revert to Oracle''s OTN license in September 2024.
For non-LTS releases like JDK 18, the license reversion will occur just six months after
the release of a successor version. Given Java''s release cadence, non-LTS releases will see
license reversion after one year.

The salient difference between the NFTC and the OTN is that the OTN disallows commercial usage.

Kevin Morrin, VP of service delivery for SLC, a consultancy for customers dealing with
Oracle licensing, told The Register in a phone interview that the licensing change is
significant for Oracle customers.

"This is a departure," he said. "It allows people to
download and use Java in organizations. It can be put into production. That''s an important nuance."

But he said while clients get free entry under the NFTC license, they still have to think
about whether they will maintain it once they have to pay for support, or whether they will
shift to the latest version to maintain the free terms.

Asked whether Oracle expects enterprise customers, traditionally slow to update, will remain
on specific Java versions long enough for payment to come into play, Morrin said that''s possible.

"Most clients wait at least a year before upgrading," he said. "There are very few early adopters
among the clients we surveyed."

Oracle, he suggested, might be using the new license as a carrot to entice more customers to
shift to the cloud.

Morrin also suggested the licensing shift could be a response to rivals like Amazon, Microsoft,
and RedHat that have their own JDKs. "I see clients standardizing on ones that aren''t charging them money," he said.

Ultimately, he said, Oracle customers should consider their options carefully. "There''s no one
at Oracle who''s incented to save you money," he said.

Paul Berg, an Idaho-based software licensing consultant who has worked for Amazon and Microsoft,
told The Register in an email that Oracle''s motives for the licensing change may have something
to do with patent licensing.

"Most likely Oracle is under a patent cross licensing agreement, most likely with Microsoft and IBM
among others," he mused. "The full rights to use these third party patents under the cross licensing
agreement that Oracle likely enjoys, likely does not allow them full redistributable rights to those
patent licenses, particularly when a recipient of the JDK may redistribute themselves.

"Oracle may not be comfortable that they can legally distribute identified third party patent
implementations under the GPLv2 without annoying their cross licensing partners. So that could be
a reason to withhold useful code from the OpenJDK that is in this proprietary version.

"A more selfish reason could be that Oracle does not want to license their own patents in the JDK
under the GPLv2, as that would diminish the value of their portfolio. This is, of course,
complete speculation on my part, but it would be a very common industry reason for this behavior."

The Register asked Oracle whether there''s anything to this speculation. We''ll update this story
if Oracle chooses to respond.
'

_resfile="docs/result-proto.txt"
_count=10

# create empty results file

[ -f "$_resfile" ] && rm "$_resfile"

touch "$_resfile"

# count input lines, words, and characters, output to results

cat <<< "$_dargs" | wc -lwc | tee -a "$_resfile"

# StringBuilder

echo "StringBuilder" >> $_resfile

for i in $(seq 1 $_count); do
  (time java -cp bin predictive.Words2SigProto <<< "${_dargs}" > /dev/null;) &>> $_resfile
done

echo >> $_resfile

# StringBuffer

echo "StringBuffer" >> $_resfile

for i in $(seq 1 $_count); do
  (time java -cp bin predictive.Words2SigProto2 <<< "${_dargs}" > /dev/null;) &>> $_resfile
done

echo >> $_resfile

# StringBuilder

echo "String" >> $_resfile

for i in $(seq 1 $_count); do
  (time java -cp bin predictive.Words2SigProto3 <<< "${_dargs}" > /dev/null;) &>> $_resfile
done

echo >> $_resfile

```

## Summary

TL;DR: StringBuilder is better implementation for longer texts and multiple concatenations.

Strings are immutable. When a string is made, it is written into the heap. If one tries to modify a string, Java will instead make a copy of it with the new modifications into memory. This makes String only effective for constant values and occasional concatenations.

Meanwhile, StringBuffer and StringBuilder are classes that can handle mutable strings as they modify internally and do not recreate new strings. Only when the result is needed then they will return a String.

StringBuffer is synchronized

