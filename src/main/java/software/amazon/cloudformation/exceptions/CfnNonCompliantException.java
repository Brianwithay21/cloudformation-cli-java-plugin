/*
* Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License").
* You may not use this file except in compliance with the License.
* A copy of the License is located at
*
*  http://aws.amazon.com/apache2.0
*
* or in the "license" file accompanying this file. This file is distributed
* on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
* express or implied. See the License for the specific language governing
* permissions and limitations under the License.
*/
package software.amazon.cloudformation.exceptions;

import software.amazon.cloudformation.proxy.HandlerErrorCode;

public class CfnNonCompliantException extends BaseHandlerException {

    private static final long serialVersionUID = -1646136434112354328L;
    private static final HandlerErrorCode ERROR_CODE = HandlerErrorCode.NonCompliant;

    public CfnNonCompliantException(final Throwable cause) {
        super(cause, ERROR_CODE);
    }

    public CfnNonCompliantException(final String hookTypeName,
                                    final String reason) {
        this(hookTypeName, reason, null);
    }

    public CfnNonCompliantException(final String hookTypeName,
                                    final String reason,
                                    final Throwable cause) {
        super(String.format(ERROR_CODE.getMessage(), hookTypeName, reason), cause, ERROR_CODE);
    }
}
