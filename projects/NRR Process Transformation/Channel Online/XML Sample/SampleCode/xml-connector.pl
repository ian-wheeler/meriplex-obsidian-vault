#!/usr/local/bin/perl -w

use strict;
use HTTP::Request::Common;
use HTTP::Request;
use HTTP::Headers;

use LWP::UserAgent;


my $in = qq~<export_documents_request schemaVersion="4.0">
  <authentication>
    <shortcut>var</shortcut>
    <email>John.Doe\@var.com</email>
    <password>password</password>
  </authentication>
  <options>
    <onlyUnexported>false</onlyUnexported>
    <eventInRange>
      <eventType>modified</eventType>
      <after>2005-01-01T10:00:00Z</after>
    </eventInRange>
  </options>
</export_documents_request>
    ~;

my $url = "https://usm.channelonline.com/REQUEST";

my $ua = new LWP::UserAgent(keep_alive => 0);
$ua->timeout(20000);

my $headers = new HTTP::Headers();
$headers->header('User-Agent' => 'ChannelOnline XML Sample Perl Connector');
my $request = new HTTP::Request('POST', $url, $headers);
$request->protocol("HTTP/1.1");
$request->content_type('text/xml');
$request->content_length(length($in));
$request->content($in);

my $response = $ua->request($request);

print "STATUS: ", $response->status_line(), "\n\n";

if ($response->is_success()) {
    my $content = $response->content();
    print "Recieved the following document";
    print $content; 
   
} else {
    print STDERR "Recieved error from ChannelOnline.";
    print STDERR $response->as_string();
}
